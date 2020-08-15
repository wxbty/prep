package ink.zfei.spring.aop;

public class CountMethodConsumTime {

    public static ThreadLocal<String> pubUid = new ThreadLocal<>();

    public void before(){//前置通知
//        String uid = Session.get("uid");
        String uid = "123222";
        pubUid.set(uid);
        System.out.println(System.currentTimeMillis());
    }

    public void clear(){//后置通知
        System.out.println(System.currentTimeMillis());

    }

}
