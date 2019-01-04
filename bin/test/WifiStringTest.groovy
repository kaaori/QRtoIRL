import org.junit.Test
import wifi.WifiString

class WifiStringTest extends GroovyTestCase {

    @Test
    void testWifiString(){
        def resultWEP = new WifiString("TestWifi", "TestPassword", true, false)
        def resultWPA = new WifiString("TestWifi", "TestPassword", false, false)
        def resultHidden = new WifiString("TestWifi", "TestPassword", true, true)

        assertEquals("WIFI:S:<TestWifi>;T:<WEP>;P:<TestPassword>;H:<false>;", resultWEP.toString())
        assertEquals("WIFI:S:<TestWifi>;T:<WPA>;P:<TestPassword>;H:<false>;", resultWPA.toString())
        assertEquals("WIFI:S:<TestWifi>;T:<WEP>;P:<TestPassword>;H:<true>;", resultHidden.toString())
    }

}
