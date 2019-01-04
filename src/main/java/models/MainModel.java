package models;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.swing.event.SwingPropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class MainModel implements IModel {
    private SwingPropertyChangeSupport changeSupporter;

    // Main window
    private int qrSize;
    private ErrorCorrectionLevel errorCorrectionLevel;
    private Boolean isUTF8 = false;
    private Boolean generateScad = false;
    private Boolean generateStl = false;
    private String fileType;
    private String fileName;

    // Text tab
    private String qrText;

    // Wifi tab
    private String ssid;
    private char[] password;
    private Boolean isWEP;
    private Boolean isHidden;

    public MainModel() {
        changeSupporter = new SwingPropertyChangeSupport(this);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        changeSupporter.addPropertyChangeListener(listener);
    }

    public ErrorCorrectionLevel getErrorCorrectionLevel() {
        return errorCorrectionLevel;
    }

    public void setErrorCorrectionLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        ErrorCorrectionLevel oldVal = this.errorCorrectionLevel;
        this.errorCorrectionLevel = errorCorrectionLevel;

        changeSupporter.firePropertyChange("errorcorrectionlevel", oldVal, errorCorrectionLevel);
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        String oldVal = this.fileType;
        this.fileType = fileType;

        changeSupporter.firePropertyChange("filetype", oldVal, fileType);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        String oldVal = this.fileName;
        this.fileName = fileName;

        changeSupporter.firePropertyChange("filename", oldVal, fileName);
    }

    public int getQrSize() {
        return qrSize;
    }

    public void setQrSize(int qrSize) {
        int oldVal = this.qrSize;
        this.qrSize = qrSize;

        changeSupporter.firePropertyChange("qrsize", oldVal, qrSize);
    }

    public Boolean getUTF8() {
        return isUTF8;
    }

    public void setUTF8(Boolean UTF8) {
        Boolean oldVal = this.isUTF8;
        this.isUTF8 = UTF8;

        changeSupporter.firePropertyChange("utf8", oldVal, isUTF8);
    }

    public Boolean getGenerateScad() {
        return generateScad;
    }

    public void setGenerateScad(Boolean generateScad) {
        Boolean oldVal = this.generateScad;
        this.generateScad = generateScad;

        changeSupporter.firePropertyChange("generatescad", oldVal, generateScad);
    }

    public Boolean getGenerateStl() {
        return generateStl;
    }

    public void setGenerateStl(Boolean generateStl) {
        Boolean oldVal = this.generateStl;
        this.generateStl = generateStl;

        changeSupporter.firePropertyChange("generatestl", oldVal, generateStl);
    }

    //region Text tab get/setters

    public String getQrText() {
        return qrText;
    }

    public void setQrText(String qrText) {
        String oldVal = this.qrText;
        this.qrText = qrText;

        changeSupporter.firePropertyChange("qrtext", oldVal, qrText);
    }
//endregion

    //region Wifi tab get/setters

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        String oldVal = this.ssid;
        this.ssid = ssid;

        changeSupporter.firePropertyChange("ssid", oldVal, ssid);
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        char[] oldVal = this.password;
        this.password = password;

        changeSupporter.firePropertyChange("password", oldVal, password);
    }

    public Boolean getWEP() {
        return isWEP;
    }

    public void setWEP(Boolean WEP) {
        isWEP = WEP;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    //endregion

    public SwingPropertyChangeSupport getChangeSupporter() {
        return changeSupporter;
    }

}
