package ink.zfei.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private int threadNum;

    private Set<Thread> threads = new HashSet<Thread>();

    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(20);


    public ThreadPool(int threadNum) {
        this.threadNum = threadNum;
    }

    public void submit(Runnable task) throws InterruptedException {
        if (threads.size() < threadNum) {
//            queue.offer(task);
            TaskThread thread = new TaskThread();
            threads.add(thread);
            thread.setDaemon(true);
            thread.start();
        }

        queue.put(task);

    }


    class TaskThread extends Thread {

        @Override
        public void run() {

            while (true) {
                try {
                    Runnable task = queue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {

        ThreadPool pool = new ThreadPool(20);

        for (int i = 0; i < 50; i++) {
            final int finalI = i;
            Runnable task = new Runnable() {
                public void run() {
                    System.out.println("执行任务" + finalI);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            pool.submit(task);
//            task.run();
        }

//        Thread.sleep(20000);

    }


}
