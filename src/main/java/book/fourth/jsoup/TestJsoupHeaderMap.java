package book.fourth.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author yangsibao
 * @date 2020/1/6-13:22
 */
public class TestJsoupHeaderMap {

    public static void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("http://www.baidu.com");

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("Host", "www.baidu.com");
        headerMap.put("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50");
        headerMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headerMap.put("Accept-Language", "zh-cn,zh;q=0.5");
        headerMap.put("Accept-Encoding", "gzip,deflate");
        headerMap.put("Cache-Control", "max-age=0");
        headerMap.put("Connection", "keep-alive");

        Connection conHeader = connect.headers(headerMap);
        Document document = conHeader.get();
        Element head = document.head();


        System.out.println(document);

//        System.out.println(head);

    }
}
