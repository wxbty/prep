package ink.zfei.spring.aop;

public class CountMethodConsumTime {



    public void buy(){//前置通知
        System.out.println(System.currentTimeMillis());
    }

    public void clear(){//后置通知
        System.out.println(System.currentTimeMillis());

    }

}
