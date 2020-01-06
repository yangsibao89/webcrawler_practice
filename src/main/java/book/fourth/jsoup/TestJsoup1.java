package book.fourth.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author yangsibao
 * @date 2020/1/6-11:34
 */
public class TestJsoup1 {

    public static void main(String[] args) {

        Connection connect = Jsoup.connect("http://www.baidu.com");

        try {
            Document document = connect.get();
            System.out.println(document.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
