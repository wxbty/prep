package ink.zfei;

public class MyArrayList {

    private String[] vals;

    private int index = 0;

    public MyArrayList() {
        vals = new String[10];
    }

    public synchronized void add(String tmp) {


        if (index == vals.length - 1) {
            //如果满了，扩容
            String[] newVals = new String[vals.length * 2];
            System.arraycopy(vals, 0, newVals, 0, vals.length);
            vals = newVals;
            System.out.println("vals.length =" + vals.length);
        }
        vals[index] = tmp;     //index=0   线程1 tmp=zhangsan   线程2 tmp=lisi
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        index++;
    }

    public String get(int i) {
        if (i < 0) {
            throw new RuntimeException();
        }
        if (i >= index) {
            throw new IndexOutOfBoundsException();
        }
        return vals[i];
    }
}
