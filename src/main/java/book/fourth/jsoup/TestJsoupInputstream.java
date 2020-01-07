package book.fourth.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.*;

/**
 * @author yangsibao
 * @date 2020/1/7-11:59
 */
public class TestJsoupInputstream {

    public static void main(String[] args) throws IOException {

//        connectionInputStream();
    }

    @Test
    public void connectionInputStream() throws IOException {
        String imageUrl = "https://www.gstatic.com/images/branding/googlemic/2x/googlemic_color_24dp.png";
        Connection connect = Jsoup.connect(imageUrl);

        //ignore,否则会报错
        Connection.Response response = connect.method(Connection.Method.GET).ignoreContentType(true).execute();

//        int i = response.statusCode();

        System.out.println(response.contentType());

        BufferedInputStream bufferedInputStream = response.bodyStream();

        saveImage(bufferedInputStream, "./image/1.jpg");

    }

    public void saveImage(BufferedInputStream inputStream, String savePath) throws IOException {
        byte[] bytes = new byte[1024];

        int len = 0;

        File file = new File(savePath);

        FileOutputStream fos = new FileOutputStream(file);

        BufferedOutputStream bos = new BufferedOutputStream(fos);

        while ((len = inputStream.read(bytes, 0, 1024)) != -1) {
            bos.write(bytes, 0, len);
        }

        bos.flush();
        bos.close();
    }
}
