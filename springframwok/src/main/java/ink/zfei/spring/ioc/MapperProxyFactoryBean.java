package ink.zfei.spring.ioc;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MapperProxyFactoryBean implements FactoryBean {
    public Object getObject() throws Exception {
        InvocationHandler handler = new MapperCreatorInvocationHandler(new Object());
        //扫描basepackages，发现有@Mapper注解类，就把这个类信息缓存，这边取出来，for循环，在这里分别生成代理类

        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{DeviceMapper.class,}, handler);

//        return new Device();
    }

    public Class<?> getObjectType() {
        return null;
    }
}
