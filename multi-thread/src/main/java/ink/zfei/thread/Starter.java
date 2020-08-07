package ink.zfei.thread;

public class Starter {
    static class MyThread extends Thread {  // 继承Thread类，作为线程的实现类
        private String name;       // 表示线程的名称
        public MyThread(String name) {
            this.name = name;      // 通过构造方法配置name属性
        }
        public void run() {  // 覆写run()方法，作为线程 的操作主体


            for (int i = 0; i < 10; i++) {
                System.out.println(name + "运行，i = " + i);
            }
        }
    }
    public static void main(String args[]) throws InterruptedException {
//        MyThread mt1 = new MyThread("线程A ");    // 实例化对象
//        MyThread mt2 = new MyThread("线程B ");    // 实例化对象
//        mt1.start();   // 调用线程主体
//        mt2.start();   // 调用线程主体
////​
        Object obj = new Object();
        MyRunnable mt3 = new MyRunnable("线程A ",obj);    // 实例化对象
//        MyRunnable mt4 = new MyRunnable("线程B ");    // 实例化对象
        Thread t1 = new Thread(mt3);       // 实例化Thread类对象
//        Thread t2 = new Thread(mt4);       // 实例化Thread类对象
        t1.start();    // 启动多线程
//        t2.start();    // 启动多线程
        System.out.println(111);
        Thread.sleep(2000);

        add(obj);
    }

     static void add( Object obj)
    {
        synchronized(obj)
        {
            System.out.println(111111);
            try {
                Thread.sleep(5000);
                obj.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyRunnable implements Runnable { // 实现Runnable接口，作为线程的实现类
        private String name;       // 表示线程的名称
        private Object obj;       // 表示线程的名称
        public MyRunnable(String name,Object obj) {
            this.name = name;      // 通过构造方法配置name属性
            this.obj = obj;      // 通过构造方法配置name属性
        }
        public void run() {  // 覆写run()方法，作为线程 的操作主体

            add(obj);
//            for (int i = 0; i < 10; i++) {
//                System.out.println(name + "运行，i = " + i);
//            }
        }
    }
}
