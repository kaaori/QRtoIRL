package qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class QRUtils {
    /**
     * Generating QR Code adapted from Pankaj at journaldev.com
     * https://www.journaldev.com/470/java-qr-code-generator-zxing-example
     * <p>
     * Changes include:
     * - Fixing grammatical errors in comments
     * - Expanding on comments
     * - Modifying code to be compatible with this project
     *
     * @param contents   Raw contents for the QR Code
     * @param outputFile File to write the end result to
     * @param fileType   Image type for the end result
     * @param qrSize     Size of the QR Code.
     * @return BitMatrix       containing Boolean values corresponding to the QR Code
     * @throws WriterException if file cannot be written to.
     * @throws IOException     if file cannot be made or written to (i.e invalid directory).
     */
    public static BitMatrix generateQRCode(String contents, File outputFile, String fileType, int qrSize, CharacterSetECI charSet, ErrorCorrectionLevel errorCorrectionLevel)
            throws WriterException, IOException {

        // Create a Hashtable and specify error correction level L
        // TODO: With UI - Allow user to select ECL
        // TODO: Error handling
        Hashtable<EncodeHintType, Object> hintTable = new Hashtable<>();
        hintTable.put(EncodeHintType.ERROR_CORRECTION, (errorCorrectionLevel == null ? ErrorCorrectionLevel.L : errorCorrectionLevel));
        hintTable.put(EncodeHintType.CHARACTER_SET, (charSet == null ? CharacterSetECI.ASCII : charSet));

        // Create the BitMatrix for the QR Code that encodes a given String
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(contents, BarcodeFormat.QR_CODE, qrSize, qrSize, hintTable);

        // Create the BufferedImage that will contain the QR Code
        int matrixWidth = bitMatrix.getWidth();
        BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);

        // Paint and save the image using the ByteMatrix
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                if (bitMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }

        // Write the image to a file and assign the global BitMatrix for generating SCAD file.
        // TODO: With UI - Allow user to toggle saving QR code to file
        // TODO: With UI - Display QR Code once generated
        ImageIO.write(image, fileType, outputFile);
        return bitMatrix;
    }
}
