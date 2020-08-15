package ink.zfei;

import java.util.TreeMap;

public class TreeMapDemo implements Comparable {


    volatile static int tp = 1;

    public static void main(String[] args) {

        TreeMapDemo demo = new TreeMapDemo();

        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        treeMap.put("zhangsan", "zhangsan");
        treeMap.put("lisi", "lisi");
//        treeMap.put(demo, "wangwu");
//        treeMap.put(demo, "zaoliu");
//        treeMap.put(demo, "mknn");
        int num = 1;
        tp = 1;
        int tp1 = 1;


        treeMap.get(demo);

//        for (Integer key : treeMap.keySet()) {
//            System.out.println("tree key = " + key + ",value=" + treeMap.get(key));
//        }

    }

    public int compareTo(Object o) {
        return 0;
    }
}
