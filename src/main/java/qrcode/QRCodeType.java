package qrcode;

public enum QRCodeType {
    TEXT_URL("Text/URL"),
    WIFI_LOGIN("Wifi Login"),
    CONTACT("Contact"),
    SMS("SMS"),
    PHONE_NUMBER("Phone Number");

    private final String uiValue;

    QRCodeType(String uiValue) {
        this.uiValue = uiValue;
    }

    @Override
    public String toString() {
        return this.uiValue;
    }
}
