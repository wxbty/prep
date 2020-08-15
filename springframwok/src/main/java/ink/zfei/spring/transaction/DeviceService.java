package ink.zfei.spring.transaction;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DeviceService {


    @Transactional
    public void create() {
        //sqlzhixing
        update();
    }


    @Transactional(rollbackFor = Exception.class)
    public void update() {


        String sql1 = " insert ...";
//        deviceMapper.insert(sql1);
        String sql2 = " update ...";
//        userMapper.insert(sql1);

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


    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("zhangsan");  //0
        list.add("zhangsan");  //1
        list.add("lisi");    //2
        list.get(2);
//        for (int i=0;i<list.size();i++)
//        {
//            String tmp = list.get(i);
//            if ("zhangsan".equals(tmp))
//            {
//                list.remove(tmp);
//            }
//        }
//        list.forEach(System.out::println);

        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.put("zhangsan","13");
        map.put("lisi","14");
        map.put("wangwu","13");

        map.get("wangwu");

        TreeSet<String> set = new TreeSet();
        set.add("zhangsan");
        set.add("lisi");
        set.add("wangwu");

    }
}
