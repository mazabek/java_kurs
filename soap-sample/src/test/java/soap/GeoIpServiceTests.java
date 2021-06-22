package soap;

import com.lavasoft.GeoIPService;
import com.lavasoft.GeoIPServiceSoap;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GeoIpServiceTests {
    @Test
    public void testMyIp(){
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("95.51.135.77");
        assertEquals(ipLocation, "<GeoIP><Country>PL</Country><State>78</State></GeoIP>");
    }

    @Test(enabled = false)
    public void testMyInvalidIp(){
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("95.51.135.xxx");
        assertEquals(ipLocation, "<GeoIP><Country>PL</Country><State>78</State></GeoIP>");
    }
}
