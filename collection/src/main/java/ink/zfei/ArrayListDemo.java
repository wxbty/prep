package ink.zfei;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {


    public static void main(String[] args) {
        final MyArrayList list = new MyArrayList();

        Thread other = new Thread(new Runnable() {
            public void run() {
                list.add("lisi");
                list.add("lisi");
                list.add("lisi");
            }
        });
        other.start();

        list.add("zhangsan");
        list.add("zhangsan");
        list.add("zhangsan");
        list.add("zhangsan");
        list.add("zhangsan");
        list.add("zhangsan");
        list.add("zhangsan");
        list.add("zhangsan");

        String tmp = list.get(0);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println(list.get(6));
        System.out.println(list.get(7));
        System.out.println(list.get(8));
        System.out.println(list.get(9));
        System.out.println(list.get(10));
    }

}
