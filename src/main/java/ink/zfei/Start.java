package ink.zfei;

import ink.zfei.controller.IndexController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableWebMvc
//@EnableAspectJAutoProxy
@EnableTransactionManagement
public class Start {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
//        SpringApplication.run(Start.class);
        System.out.println(11111);
//        IndexController index = new IndexController();
//        Class obj = IndexController.class;
//        Constructor<?>[] ctos = obj.getDeclaredConstructors();
//        IndexController index1 = (IndexController) obj.newInstance();

//        ctos[0].setAccessible(true);
//        IndexController index2 = (IndexController) ctos[0].newInstance();

//        System.out.println(index2.num);
//        System.out.println("hello world!");


        //springboot启动时做的事情
//        Map<String, Object> handleControllerMapping = new HashMap<String, Object>();
//        handleControllerMapping.put("index/queryStatus", new IndexController());
//
//        Map<String, String> handleMethodMapping = new HashMap<String, String>();
//        handleMethodMapping.put("index/queryStatus", "queryStatus");
//
//        Map<String, Class[]> handleMethodParameterMapping = new HashMap<String, Class[]>();
//        Class[] objs = new Class[2];
//        objs[0] = Integer.class;
//        objs[1] = String.class;
//        handleMethodParameterMapping.put("index/queryStatus", objs);
//
//
//        //http接口调用时的操作
//        String path = "index/queryStatus";
//        Object handleController = handleControllerMapping.get(path);
//        String handleMethod = handleMethodMapping.get(path);
//
//        Class clazz = handleController.getClass();
//
//        Class[] paras = handleMethodParameterMapping.get(path);
//
//
//        Method method = clazz.getDeclaredMethod(handleMethod, paras);
//        String parametes = "deviceId=1&name=zhangsan";
//        String[] pas = parametes.split("&");
//
//
//
//
//        Object resul = method.invoke(handleController, pas);


    }


}
