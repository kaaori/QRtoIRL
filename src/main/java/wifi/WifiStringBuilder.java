package wifi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class WifiStringBuilder {
    private String ssid;
    private char[] password;
    private Boolean isWEP;
    private Boolean isHidden;

    /**
     * @param ssid     Network name
     * @param password Network password as char[] from password field
     * @param isWEP    Is the network WEP
     * @param isHidden Is the network hidden
     */
    public WifiStringBuilder(String ssid, char[] password, Boolean isWEP, boolean isHidden) {
        ssid = escape(ssid);
        password = escape(String.valueOf(password)).toCharArray();

        this.ssid = ssid;
        this.password = password;
        this.isWEP = isWEP;
        this.isHidden = isHidden;
    }

    /**
     *
     * @param input Input to escape
     * @return The escaped string.
     */
    private String escape(String input) {
        // Character[] is used in place of char[] to avoid Arrays. in favour of .contains
        Character[] toEscape = new Character[]{'\\', ';', ',', ':', '"'};
        StringBuilder output = new StringBuilder();
        for (char c :
                input.toCharArray()) {
            // If char exists in array
            if (Arrays.asList(toEscape).contains(c)) {
                output.append("\\")
                        .append(c);
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    /**
     * @return QR Code ready formatted string for WIFI connection
     */
    @Override
    public String toString() {
        String output = String.format("WIFI:" +
                "S:\"%s\";" +
                "T:%s;" +
                "P:%s;" +
                "%s;", ssid, (isWEP ? "WEP" : "WPA"), String.valueOf(password), isHidden ? "H:true" : "");;
        // 0 out password array now that we are done with it
        Arrays.fill(this.password, '0');
        return output;
    }
}
