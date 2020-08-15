package ink.zfei;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayListRemove {

    public volatile static AtomicInteger num = new AtomicInteger(5);  //内存

    //加了volatile，变量寄存器马上刷新到内存，通知其他线程更新寄存器缓存
    public static void main(String[] args) {
//        List<String> tmps = new ArrayList();
//        tmps.add("lisi");
//        tmps.add("lisi");
//        tmps.add("lisi");
//        tmps.add("zhangsan");
//        tmps.add("zhangsan");
//        tmps.add("zhangsan");
//        tmps.add("wangwu");
//        tmps.add("wangwu");
//        tmps.add("wangwu");
//        tmps.add("wangwu");
//
        new Thread(new Runnable() { //对应cpu2
            public void run() {
                System.out.println(num); //第二步   num= 6
            }
        }).start();

        new Thread(new Runnable() {   //对应cpu1 （寄存器num ++，num 5->6）
            public void run() {
//               num =7;   //第一步
//                num.addAndGet(2);    //不是原子操作, 自增操作+赋值  num = num+2
                //num =6  //线程2 停在这
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(11);
            }
        }).start();

//        for (int i = tmps.size()-1; i >= 0; i--) {
//            String tmp = tmps.get(i);
//            if (tmp.equals("zhangsan")) {
//                tmps.remove(i);
//            }
//        }

        TreeSet<String> set = new TreeSet<String>();
        set.add("zhangsan");
        set.add("zhangsan");

        System.out.println(set.remove("zhangsan"));


        //fail-fast


//        for (String tmp : tmps) {
//            if (tmp.equals("zhangsan")) {
//                tmps.remove(tmp);
//            }
//        }
//        Iterator<String> it = tmps.iterator();
//        while (it.hasNext())
//        {
//            String tmp = it.next();
//            if (tmp.equals("zhangsan")) {
//                 tmps.remove(tmp);
//             }
//        }

//        for (String tmp : tmps) {
//            System.out.println(tmp);
//        }

    }

    private synchronized int numAdd(int num) {
        return num++;
    }

}
