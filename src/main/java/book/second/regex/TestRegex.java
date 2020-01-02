package book.second.regex;

/**
 * @author yangsibao
 * @date 2020/1/2-13:51
 */
public class TestRegex {

    public static void main(String[] args) {

        String url = "//i.********.com.cn/75975500";

        String user_id = url.replaceAll("\\D", "");

        System.out.println(user_id);

        String content = "正则表达式-CSDN博客";

        String[] contentRegex = content.split("\\p{Punct}");

        System.out.println(contentRegex[0]);

    }
}
