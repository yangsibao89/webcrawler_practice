package book.second.log;

import org.apache.log4j.Logger;

/**
 * @author yangsibao
 * @date 2020/1/2-16:00
 */
public class TestLogger {

    static final Logger logger = Logger.getLogger(TestLogger.class);

    public static void main(String[] args) {
        System.out.println("hello");

        //log out

        logger.info("hello world info");
        logger.debug("this is debug message");
        logger.warn("this is warn message");
        logger.error("this is error message");

    }

}
