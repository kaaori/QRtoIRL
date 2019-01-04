import org.junit.Test
import qrcode.QRUtils

class QRTest extends GroovyTestCase {

    @Test
    void testQrCode() {
        def qrBitMatrix = QRUtils.generateQRCode("TestQR", new File("qrTest.png"), "png", 225)

        assertEquals(225, qrBitMatrix.getWidth())
        assertEquals(225, qrBitMatrix.getHeight())
        assertEquals(8, qrBitMatrix.rowSize)
    }

}