/*
 *
 * A simple application to take user-entered data, convert it to a QR code, and generate a valid CAD file.
 *      - Can export as .scad for OpenSCAD to be rendered later
 *      - Can export directly as .STL by going through OpenSCAD's CLI
 *        (The above requires OpenSCAD portable to be downloaded and in the running directory)
 *        -
 *
 * The output file is intended for use with a slicer program to ultimately 3d print the generated QR code.
 *
 * The final file will generate a base layer for the "Quiet Zone" and base body of the QR code, and subsequent layers for the encoded data.
 *
 *
 * */


import com.google.zxing.WriterException;
import ui.MainView;

import java.io.IOException;
// TODO: Full javadoc for classes

public class QRtoIRL {
    public static void main(String[] args) throws WriterException, IOException {
        new MainView();
    }
}