package ui;

public enum PanelTab {
    TEXT(0),
    WIFI(1),
    CONTACT(2),
    PHONE_NUMBER(3),
    SMS(4);

    private final int tabIndex;

    PanelTab(int tabIndex) {
        this.tabIndex = tabIndex;
    }
}
