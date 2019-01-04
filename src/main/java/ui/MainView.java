package ui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import controllers.MainController;
import models.MainModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainView extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane mainTabPanel;
    private JPanel textTab;
    private JPanel wifiTab;
    private JPanel contactTab;
    private JPanel phoneNumTab;
    private JPanel smsTab;
    private JButton qrButton;
    private JTextField dataTextField;
    private JTextField ssidTextField;
    private JPasswordField passwordPassField;
    private JCheckBox WEPCheckBox;
    private JCheckBox hiddenCheckBox;
    private JPanel exportOptionsPanel;
    private JButton qrScadButton;
    private JButton qrScadStlButton;
    private JPanel eclPanel;
    private JRadioButton highRadioButton;
    private JRadioButton quartileRadioButton;
    private JRadioButton mediumRadioButton;
    private JTextField textField1;
    private JPanel textPanel;
    private JCheckBox UTF8CheckBox;
    private JRadioButton lowRadioButton;
    private JLabel lblText;
    private JPanel sizePanel;
    private JSpinner sizeSpinner;
    private JCheckBox generateSCADCheckBox;
    private JCheckBox generateSTLCheckBox;
    private JTextField fileNameTextField;
    private JComboBox fileTypeCmbBox;
    private ButtonGroup eclButtonGroup;

    public MainView() {

        $$$setupUI$$$();

        // Init UI element values
        lowRadioButton.setActionCommand("L");
        mediumRadioButton.setActionCommand("M");
        quartileRadioButton.setActionCommand("Q");
        highRadioButton.setActionCommand("H");
        sizeSpinner.setModel(new SpinnerNumberModel(255, 1, 1000, 1));

        MainModel mainModel = new MainModel();
        MainController mainController = new MainController(this, mainModel);

        setTitle("QR2IRL");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public JComboBox getFileTypeCmbBox() {
        return fileTypeCmbBox;
    }

    public JTextField getFileNameTextField() {
        return fileNameTextField;
    }

    public JCheckBox getGenerateSCADCheckBox() {
        return generateSCADCheckBox;
    }

    // TODO: implement scad -> stl thru openSCAD cli
    public JCheckBox getGenerateSTLCheckBox() {
        return generateSTLCheckBox;
    }

    public JTabbedPane getMainTabPanel() {
        return mainTabPanel;
    }

    public JCheckBox getUTF8CheckBox() {
        return UTF8CheckBox;
    }

    public JButton getQrButton() {
        return qrButton;
    }

    public JSpinner getSizeSpinner() {
        return sizeSpinner;
    }

    public JTextField getDataTextField() {
        return dataTextField;
    }

    public JTextField getSsidTextField() {
        return ssidTextField;
    }

    public JPasswordField getPasswordPassField() {
        return passwordPassField;
    }

    public JCheckBox getWEPCheckBox() {
        return WEPCheckBox;
    }

    public JCheckBox getHiddenCheckBox() {
        return hiddenCheckBox;
    }

    public JRadioButton getHighRadioButton() {
        return highRadioButton;
    }

    public JRadioButton getQuartileRadioButton() {
        return quartileRadioButton;
    }

    public JRadioButton getMediumRadioButton() {
        return mediumRadioButton;
    }

    public JRadioButton getLowRadioButton() {
        return lowRadioButton;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), 10, 10));
        mainPanel.setMaximumSize(new Dimension(2147483647, 2147483647));
        mainPanel.setMinimumSize(new Dimension(650, 450));
        mainPanel.setPreferredSize(new Dimension(650, 450));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "QR2IRL", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, -1, -1, mainPanel.getFont())));
        mainTabPanel = new JTabbedPane();
        mainTabPanel.setEnabled(true);
        mainPanel.add(mainTabPanel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(100, 100), null, 0, false));
        textTab = new JPanel();
        textTab.setLayout(new GridBagLayout());
        mainTabPanel.addTab("Text/URL", textTab);
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        textTab.add(textPanel, gbc);
        dataTextField = new JTextField();
        dataTextField.setText("");
        textPanel.add(dataTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 42), null, 0, false));
        lblText = new JLabel();
        lblText.setText("Enter text or URL:");
        textPanel.add(lblText, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(90, 42), null, 0, false));
        wifiTab = new JPanel();
        wifiTab.setLayout(new GridBagLayout());
        mainTabPanel.addTab("Wifi", wifiTab);
        final JLabel label1 = new JLabel();
        label1.setText("Password:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        wifiTab.add(label1, gbc);
        ssidTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        wifiTab.add(ssidTextField, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("SSID/Network Name:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        wifiTab.add(label2, gbc);
        passwordPassField = new JPasswordField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        wifiTab.add(passwordPassField, gbc);
        WEPCheckBox = new JCheckBox();
        WEPCheckBox.setText("WEP?");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        wifiTab.add(WEPCheckBox, gbc);
        hiddenCheckBox = new JCheckBox();
        hiddenCheckBox.setText("Hidden?");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        wifiTab.add(hiddenCheckBox, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        wifiTab.add(spacer1, gbc);
        contactTab = new JPanel();
        contactTab.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        contactTab.setEnabled(true);
        contactTab.setVisible(false);
        mainTabPanel.addTab("Contact", contactTab);
        mainTabPanel.setEnabledAt(2, false);
        final JScrollPane scrollPane1 = new JScrollPane();
        contactTab.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        scrollPane1.setViewportView(panel1);
        final JLabel label3 = new JLabel();
        label3.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label3, gbc);
        textField1 = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(textField1, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label4, gbc);
        final JTextField textField2 = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(textField2, gbc);
        phoneNumTab = new JPanel();
        phoneNumTab.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        phoneNumTab.setEnabled(true);
        phoneNumTab.setMinimumSize(new Dimension(0, 0));
        phoneNumTab.setVisible(false);
        mainTabPanel.addTab("Phone Number", phoneNumTab);
        mainTabPanel.setEnabledAt(3, false);
        smsTab = new JPanel();
        smsTab.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        smsTab.setEnabled(true);
        smsTab.setMinimumSize(new Dimension(0, 0));
        smsTab.setVisible(false);
        mainTabPanel.addTab("SMS", smsTab);
        mainTabPanel.setEnabledAt(4, false);
        exportOptionsPanel = new JPanel();
        exportOptionsPanel.setLayout(new GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(exportOptionsPanel, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        exportOptionsPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        final JLabel label5 = new JLabel();
        label5.setText("Generate:");
        exportOptionsPanel.add(label5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        qrButton = new JButton();
        qrButton.setText("QR Code");
        exportOptionsPanel.add(qrButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        generateSCADCheckBox = new JCheckBox();
        generateSCADCheckBox.setText(".SCAD");
        exportOptionsPanel.add(generateSCADCheckBox, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        generateSTLCheckBox = new JCheckBox();
        generateSTLCheckBox.setEnabled(false);
        generateSTLCheckBox.setText(".STL (may take 2+ minutes)");
        exportOptionsPanel.add(generateSTLCheckBox, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        eclPanel = new JPanel();
        eclPanel.setLayout(new GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(eclPanel, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        eclPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        final JLabel label6 = new JLabel();
        label6.setText("Error Correction Level (density):");
        label6.setVerticalTextPosition(0);
        eclPanel.add(label6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        highRadioButton = new JRadioButton();
        highRadioButton.setText("High (30%)");
        eclPanel.add(highRadioButton, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        quartileRadioButton = new JRadioButton();
        quartileRadioButton.setText("Quartile (25%)");
        eclPanel.add(quartileRadioButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mediumRadioButton = new JRadioButton();
        mediumRadioButton.setText("Med (15%)");
        eclPanel.add(mediumRadioButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lowRadioButton = new JRadioButton();
        lowRadioButton.setSelected(true);
        lowRadioButton.setText("Low (7%)");
        eclPanel.add(lowRadioButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sizePanel = new JPanel();
        sizePanel.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(sizePanel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(338, 34), null, 0, false));
        sizePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        final JLabel label7 = new JLabel();
        label7.setText("Size (1-1000):");
        sizePanel.add(label7, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sizeSpinner = new JSpinner();
        sizePanel.add(sizeSpinner, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(121, 30), null, 0, false));
        UTF8CheckBox = new JCheckBox();
        UTF8CheckBox.setText("UTF8? (Kanji/Kana etc) ");
        sizePanel.add(UTF8CheckBox, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(2, 4, new Insets(5, 5, 5, 5), -1, -1));
        panel2.setEnabled(true);
        mainPanel.add(panel2, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        fileNameTextField = new JTextField();
        fileNameTextField.setEnabled(false);
        panel2.add(fileNameTextField, new GridConstraints(1, 0, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Output File name:");
        panel2.add(label8, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fileTypeCmbBox = new JComboBox();
        fileTypeCmbBox.setEnabled(false);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("png");
        defaultComboBoxModel1.addElement("jpg");
        fileTypeCmbBox.setModel(defaultComboBoxModel1);
        panel2.add(fileTypeCmbBox, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        eclButtonGroup = new ButtonGroup();
        eclButtonGroup.add(highRadioButton);
        eclButtonGroup.add(quartileRadioButton);
        eclButtonGroup.add(mediumRadioButton);
        eclButtonGroup.add(lowRadioButton);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
