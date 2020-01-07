package book.fourth.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * @author yangsibao
 * @date 2020/1/7-10:57
 */
public class TestJsoupProxy {

    public static void main(String[] args) throws IOException {

    }


    @Test
    public void proxy() throws IOException {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("171.12.112.109", 9999));

        Connection connection = Jsoup.connect("https://www.baidu.com").proxy(proxy);

        Connection.Response response = connection.method(Connection.Method.GET).timeout(10 * 1000).execute();

        int statusCode = response.statusCode();

        System.out.println(statusCode);

    }
}
