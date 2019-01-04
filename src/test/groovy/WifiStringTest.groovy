import org.junit.Test
import wifi.WifiStringBuilder

class WifiStringTest extends GroovyTestCase {

    @Test
    void testWifiString(){
        def resultWEP = new WifiStringBuilder("TestWifi", "TestPassword".toCharArray(), true, false)
        def resultWPA = new WifiStringBuilder("TestWifi", "TestPassword".toCharArray(), false, false)
        def resultHidden = new WifiStringBuilder("TestWifi", "TestPassword".toCharArray(), true, true)
        def resultEscaped = new WifiStringBuilder("begin \\ ; , : \" end", "TestPassword".toCharArray(), true, true)

        assertEquals('WIFI:S:"TestWifi";T:WEP;P:TestPassword;;', resultWEP.toString())
        assertEquals('WIFI:S:"TestWifi";T:WPA;P:TestPassword;;', resultWPA.toString())
        assertEquals('WIFI:S:"TestWifi";T:WEP;P:TestPassword;H:true;', resultHidden.toString())
        assertEquals('WIFI:S:"begin \\\\ \\; \\, \\: \\" end\";T:WEP;P:TestPassword;H:true;', resultEscaped.toString())
    }

}
