package book.fourth.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author yangsibao
 * @date 2020/1/6-11:44
 */
public class TestJsoup2 {

    public static void main(String[] args) {
        Connection.Response response;
        try {
            response = Jsoup.connect("http://www.baidu.com").method(Connection.Method.GET).execute();

            URL url = response.url();

            System.out.println("response.url : " + url);

            int statusCode = response.statusCode();

            System.out.println("response.statusCode is : " + statusCode);

            String contentType = response.contentType();

            System.out.println("response.contentType is : " + contentType);

            String statusMessage = response.statusMessage();

            System.out.println("response.statusMessage is : " + statusMessage);

            if (statusCode == 200) {
                String html = new String(response.bodyAsBytes(), StandardCharsets.UTF_8);

                Document document = response.parse();

                //这里的html和document是一样的，但document是经过格式化的

                System.out.println(html);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
