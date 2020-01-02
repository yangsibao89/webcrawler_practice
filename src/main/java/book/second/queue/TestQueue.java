package book.second.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangsibao
 * @date 2020/1/2-11:22
 */
public class TestQueue {

    public static void main(String[] args) {
        Queue<String> urlQueue = new LinkedList<String>();

        urlQueue.offer("https://movie.douban.com/subject/27202818/");
        urlQueue.offer("https://movie.douban.com/subject/10808442");
        urlQueue.offer("https://movie.douban.com/subject/1291557");
        urlQueue.offer("https://movie.douban.com/subject/1292328");
        urlQueue.offer("https://movie.douban.com/subject/1293839");

        for (String uq : urlQueue) {
            System.out.println(uq);
        }

//        System.out.println("========================");

        //返回队列头元素，并在队列中删除
//        String poll = urlQueue.poll();

        System.out.println("poll:第一个url为" + urlQueue.poll());

        for (String uq : urlQueue) {
            System.out.println(uq);
        }

//        System.out.println("========================");

        System.out.println("element:第一个url为" + urlQueue.element());
        for (String uq : urlQueue) {
            System.out.println(uq);
        }

        System.out.println("peek:第一个url为" + urlQueue.peek());

        for (String uq : urlQueue) {
            System.out.println(uq);
        }

        if (urlQueue.isEmpty()) {
            System.out.println("uq为空");
        } else {
            System.out.println("uq的长度为" + urlQueue.size());
        }


    }
}
