package ink.zfei.spring.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeviceService {

    @Transactional
    public void create()
    {
        //sqlzhixing
        update();
    }


    @Transactional(rollbackFor = Exception.class)
    public void update() {

        String sql1 = " insert ...";
        String sql2 = " update ...";

        throw new RuntimeException();
    }


    //  InvocationHandler
    //  if(带了Transactional注解 )
//    {
//        begin;
//        sql...
//        commit...
//    }else
//    {
//        method.invoke(obj,args);
//    }


    //mysql隔离级别/事务  mvvc
    //spring 传播属性



}
