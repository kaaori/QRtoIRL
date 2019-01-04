package controllers;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import models.MainModel;
import qrcode.DefaultParameters;
import qrcode.QRUtils;
import scad.ScadUtils;
import ui.MainView;
import ui.PanelTab;
import wifi.WifiStringBuilder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainController implements PropertyChangeListener {
    // Copy PanelTab.values() to a constant array to save on performance as enum.values() is expensive
    private final PanelTab[] panelTabValues = PanelTab.values();
    private MainView mainView;
    private MainModel mainModel;
    // Setup for determining context of global buttons and tab indices
    private PanelTab currentPanelTab = PanelTab.TEXT;
    private Boolean isUTF8 = false;

    public MainController(MainView mainView, MainModel mainModel) {
        this.mainView = mainView;
        this.mainModel = mainModel;

        this.mainModel.addListener(this);

        setupViewEvents();

        // Ensure default values are updated in model
        mainModel.setQrSize((int) mainView.getSizeSpinner().getValue());
        mainModel.setUTF8(mainView.getUTF8CheckBox().isSelected());
        mainModel.setErrorCorrectionLevel(ErrorCorrectionLevel.L);
        mainModel.setFileName("Test");
    }

    private void setupViewEvents() {
        mainView.getMainTabPanel().addChangeListener(e -> {
            JTabbedPane mainTabPanel = (JTabbedPane) e.getSource();
            int selectedIndex = mainTabPanel.getSelectedIndex();
            currentPanelTab = panelTabValues[selectedIndex];
        });

        mainView.getSizeSpinner().addChangeListener(e -> {
            JSpinner sizeSpinner = (JSpinner) e.getSource();
            mainModel.setQrSize((int) sizeSpinner.getValue());
        });

        mainView.getUTF8CheckBox().addActionListener(e -> mainModel.setUTF8(mainView.getUTF8CheckBox().isSelected()));

        //region Set up ECL radiobutton action listeners

        mainView.getLowRadioButton().addActionListener(e -> mainModel.setErrorCorrectionLevel(ErrorCorrectionLevel.L));
        mainView.getMediumRadioButton().addActionListener(e -> mainModel.setErrorCorrectionLevel(ErrorCorrectionLevel.M));
        mainView.getQuartileRadioButton().addActionListener(e -> mainModel.setErrorCorrectionLevel(ErrorCorrectionLevel.Q));
        mainView.getHighRadioButton().addActionListener(e -> mainModel.setErrorCorrectionLevel(ErrorCorrectionLevel.H));

        //endregion

        mainView.getQrButton().addActionListener(e -> {
            String contentsToGenerate = "";

            switch (currentPanelTab) {

                case TEXT:
                    contentsToGenerate = getDataFromText();
                    break;
                case WIFI:
                    contentsToGenerate = getDataFromWifi().toString();
                    break;
                case CONTACT:
                    //TODO: contact
                    break;
                case PHONE_NUMBER:
                    //TODO: phone #
                    break;
                case SMS:
                    //TODO: sms
                    break;
            }

            if (Objects.equals(contentsToGenerate, "")) {
                contentsToGenerate = "You need to supply some text to go here!";
            }

            generateQrCode(contentsToGenerate, mainModel.getErrorCorrectionLevel(), isUTF8);

            if (mainView.getGenerateSCADCheckBox().isSelected()){
//                ScadUtils.scadFromFile();
            }


            displayQrCode();
        });

    }

    private WifiStringBuilder getDataFromWifi() {
        String ssid = mainView.getSsidTextField().getText();
        char[] password = mainView.getPasswordPassField().getPassword();
        Boolean isWEP = mainView.getWEPCheckBox().isSelected();
        Boolean isHidden = mainView.getHiddenCheckBox().isSelected();

        return new WifiStringBuilder(ssid, password, isWEP, isHidden);
    }

    private String getDataFromText() {
        String currentText = mainView.getDataTextField().getText();
        isUTF8 = mainModel.getUTF8();

        return currentText;
    }

    private void displayQrCode() {
        try {
            BufferedImage img = ImageIO.read(new File(DefaultParameters.QR_PATH));
            JLabel imgLabel = new JLabel(new ImageIcon(img));
            JOptionPane.showMessageDialog(null, imgLabel, "Generate QR", JOptionPane.PLAIN_MESSAGE, null);
        } catch (IOException err) {
            JOptionPane.showMessageDialog(mainView, err);
            err.printStackTrace();
        }
    }

    private void generateQrCode(String content, ErrorCorrectionLevel errorCorrectionLevel, Boolean isUTF8) {
        try {
            QRUtils.generateQRCode(content, new File(DefaultParameters.QR_PATH), DefaultParameters.IMAGE_TYPE, mainModel.getQrSize(), (isUTF8 ? CharacterSetECI.UTF8 : CharacterSetECI.ASCII), errorCorrectionLevel);
        } catch (WriterException | IOException err) {
            JOptionPane.showMessageDialog(mainView, err);
            err.printStackTrace();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
