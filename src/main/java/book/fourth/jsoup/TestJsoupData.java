package book.fourth.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author yangsibao
 * @date 2020/1/7-10:38
 */
public class TestJsoupData {

    public static void main(String[] args) throws IOException {

        Connection connect = Jsoup.connect("https://www.runoob.com/");

        connect.data("s", "xhr");

        Connection.Response response = connect.method(Connection.Method.GET).ignoreContentType(true).execute();

        Document document = response.parse();

        System.out.println(document);
    }
}
