package ink.zfei.sync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableDemo {


    public static void main(String[] args) {

        Callable callable = new Callable() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 5 + 6;
            }
        };
        Callable callable1 = new Callable() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 5 + 7;
            }
        };
        Callable callable2 = new Callable() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 5 + 8;
            }
        };

        FutureTask<Integer> task = new FutureTask(callable);
        FutureTask<Integer> task1 = new FutureTask(callable1);
        FutureTask<Integer> task2 = new FutureTask(callable2);
        new Thread(task).start();
        try {
            int num = task.get();
            int num1 = task1.get();
            int num2 = task2.get();
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

//        int[] num = {num,num1,num2};
//        return num;
    }
}
