package ua.olebas.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTest {

    @Test
    public void testMyIp() {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap().getGeoIP("193.239.254.187");
        Assert.assertEquals(geoIP.getCountryCode(), "UA");
    }
}
