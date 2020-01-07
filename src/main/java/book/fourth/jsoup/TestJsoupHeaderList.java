package book.fourth.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author yangsibao
 * @date 2020/1/6-13:34
 */
public class TestJsoupHeaderList {

    public static void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("http://www.baidu.com");


        Builder builder = new Builder();

        builder.host = "www.testhost.com.cn";

        HashMap<String, String> header = new HashMap<>();

        header.put("Host", builder.host);
        header.put("User-Agent", builder.userAgentList.get(new Random().nextInt(builder.userAgentSize)));
        header.put("Accept", builder.accept);
        header.put("Referer", builder.refererList.get(new Random().nextInt(builder.refererSize)));
        header.put("Accept-Language", builder.acceptLanguage);
        header.put("Accept-Encoding", builder.acceptEncoding);

        Connection conHeader = connect.headers(header);

        Document document = conHeader.get();

        System.out.println(document);


    }


    static class Builder {

        String[] userAgents = {"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50",
                "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50",
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:2.0.1) Gecko/20100101 Firefox/4.0.1",
                "User-Agent:Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11"};


        List<String> userAgentList = Arrays.asList(userAgents);

        int userAgentSize = userAgentList.size();

        String[] refererStr = {"http://www.baidu.com/",
                "http://www.googel.com/", "http://www.amazon.com/",
                "http://www.jingdong.com/", "http://www.taobao.com/",
                "http://www.tencent.com/"};
        List<String> refererList = Arrays.asList(refererStr);

        int refererSize = refererList.size();

        String accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8";
        String acceptLanguage = "zh-cn,zh;q=0.5";
        String acceptEncoding = "gzip,deflate";
        String host;

    }
}
