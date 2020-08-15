package ink.zfei;

import java.util.concurrent.*;

public class LinkedListDemo {


    private Node first = new Node(null);
    private int size = 0;

    public static void main(String[] args) {

        LinkedListDemo list = new LinkedListDemo();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        String tmp = list.get(1);
        System.out.println();
//        String first = list.getFirst();


    }

    private String get(int i) {

        return null;
    }

    private void add(String zhangsan) {
        int index = 0;


    }


    static class Node {
        private String val;

        public void setNext(Node next) {
            this.next = next;
        }

        private Node next;

        Node(String val) {
            this.val = val;
        }


    }
}
