package book.fourth.httpClient;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

/**
 * @author yangsibao
 * @date 2020/1/7-14:37
 */
public class TestHttpClient {

    public static void main(String[] args) {

    }

    @Test
    public void getInstance() throws URISyntaxException {

        String url = "http://www.baidu.com";
        URI uri = new URIBuilder(url).build();
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(uri);
        System.out.println(httpGet);

        HttpGet httpGet1 = new HttpGet(uri);
        System.out.println(httpGet1);

        HttpGet httpGet2 = new HttpGet(url);
        System.out.println(httpGet2);
    }

    @Test
    public void testHttpClientExecute() throws IOException {
        //init httpContext
        BasicHttpContext basicHttpContext = new BasicHttpContext();
        String url = "http://www.baidu.com";

        //init httpClient
        HttpClient httpClient = HttpClients.custom().build();
        HttpGet httpGet = new HttpGet(url);

        //get response
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet, basicHttpContext);

        } catch (IOException e) {
            e.printStackTrace();

        }

        System.out.println("response is : " + httpResponse);

        String stauts = httpResponse.getStatusLine().toString();
        System.out.println("Status is : " + stauts);

        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code is : " + statusCode);

        ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
        System.out.println("Protocol Version is : " + protocolVersion);

        String reasonPhrase = httpResponse.getStatusLine().getReasonPhrase();
        System.out.println("Reason Phrase is : " + reasonPhrase);

        Header[] allHeaders = httpResponse.getAllHeaders();
        System.out.println("print header info ：");
        for (int i = 0; i < allHeaders.length; i++) {
            System.out.println(allHeaders[i]);
        }

        System.out.println("header info end");

        if (statusCode == HttpStatus.SC_OK) {
            HttpEntity entity = httpResponse.getEntity();

            String entityString = EntityUtils.toString(entity, Charset.forName("UTF-8"));

            System.out.println(entityString);

            //consume entity
            EntityUtils.consume(httpResponse.getEntity());
        } else {
            //close httpEntity
            EntityUtils.consume(httpResponse.getEntity());
        }
    }
}
