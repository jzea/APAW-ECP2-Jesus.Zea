package http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpRequestTest {

    @Test
    void testToString() {
        HttpRequest httpRequest = new HttpRequest("/path", HttpMethod.GET);
        httpRequest.addQueryParam("key1", "value1");
        httpRequest.addQueryParam("key2", "value2");
        assertEquals(0, httpRequest.toString().indexOf("GET /path?key1=value1&key2=value2"));
    }

    @Test
    void testIsEqualsPathTrue() {
        HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
        assertTrue(httpRequest.isEqualsPath("path/{id}/path"));

    }

    @Test
    void testIsEqualsPathFalseForDistinct() {
        HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
        assertFalse(httpRequest.isEqualsPath("path2/{id}/path"));
    }

    @Test
    void testIsEqualsPathFalseForLength() {
        HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
        assertFalse(httpRequest.isEqualsPath("path/{id}/path/other"));
    }

}
