package book.fourth.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author yangsibao
 * @date 2020/1/6-12:37
 */
public class TestJsoupHeader {

    public static void main(String[] args) throws IOException {
//
//        String proxyHost = "127.0.0.1";
//        String proxyPort = "1080";
//
//        System.setProperty("http.proxyHost", proxyHost);
//        System.setProperty("http.proxyPort", proxyPort);
//        System.setProperty("https.proxyHost", proxyHost);
//        System.setProperty("https.proxyPort", proxyPort);


        Connection connect = Jsoup.connect("http://bulletin.cebpubservice.com/biddingBulletin/2020-01-07/2429854.html");
        Connection newHeaderConnection = connect.header("User-Agent", "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; en) Presto/2.8.131 Version/11.11");
        Document document = newHeaderConnection.get();
        System.out.println(document);

    }
}
