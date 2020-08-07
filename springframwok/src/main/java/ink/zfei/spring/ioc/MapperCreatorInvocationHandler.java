package ink.zfei.spring.ioc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperCreatorInvocationHandler implements InvocationHandler {

    MapperCreatorInvocationHandler(Object bean)
    {
        this.bean = bean;
    }
    private Object bean;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //通过 jdbc 从数据库查询数据
        System.out.println("通过 jdbc 从数据库查询数据");
        System.out.println("参数="+args[0]);
        int result = 10;
        return method.invoke(bean,args);
    }
}
