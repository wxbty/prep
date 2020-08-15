package ink.zfei.sync;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SyncDemo {

    static int num = 5;

    static ReentrantLock lock = new ReentrantLock();
    // 修饰普通方法
    public synchronized void test1() {
        //doing something
    }
    // 修饰静态方法
    public void test2() {
//        Condition condition = lock.newCondition(); //阻塞
//        try {
//            condition.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        lock.lock();
//        if (lock.tryLock()) {
//            this.test3();
//        }else
//        {
//            return;
//        }
        lock.unlock();
    }
    // 修饰代码块
    public void test3() {
        synchronized (this) {
            //doing something
        }
    }
    public static void main(String[] args) {
        SyncDemo demo = new SyncDemo();
//        demo.test2();
//        demo.test3();
        demo.test2();
        Thread thread1 =   new Thread(new Runnable() {
            @Override
            public void run() {
//                SyncDemo demo1 = new SyncDemo();
                demo.test2();
            }
        });
        thread1 .start();
        thread1.interrupt();
        demo.test2(); //main线程 竞争
        new Thread(new Runnable() {
            @Override
            public void run() {
//                SyncDemo demo1 = new SyncDemo();
                demo.test2();
            }
        }).start();
    }


}
