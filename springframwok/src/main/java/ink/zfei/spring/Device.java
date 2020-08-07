package ink.zfei.spring;

import demo.BeanAquire;
import demo.SpringBeanUtil;
import ink.zfei.spring.ioc.User;
import ink.zfei.spring.listener.PrintEvent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Arrays;

public class Device implements InitializingBean, ApplicationContextAware {


    public Device()
    {
        System.out.println("----device new ...---");
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Device{" +
                "user=" + user +
                ", name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void initAnnation()
    {
        System.out.println("device Annation  初始化中");
    }


    public void init()
    {
        System.out.println("device init-method  初始化中");
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("依赖注入name");
        this.name = name;
    }

    private String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("依赖注入password。。。。");
        this.password = password;
    }

    private String password;

    public void print()
    {
//        long befor = System.currentTimeMillis();
        System.out.println(this);
//        long after = System.currentTimeMillis();
//        System.out.println("print method consum  time="+(after-befor));

      String[]  beans   = applicationContext.getBeanDefinitionNames();
        Arrays.asList(beans).stream().forEach(System.out::print);
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Device device = new Device();
//        User user =   new User();
//        user.setName("zhangsan");
//        device.setUser(user);

//        Class clazz  = Class.forName("ink.zfei.spring.Device");
//        Device device = (Device) clazz.newInstance();
//        System.out.println(device);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml") ;
//        User user = (User) ctx.getBean("user");
//        System.out.println(user);
//
//        Device device = (Device) ctx.getBean("deviceA");
//        System.out.println(device);

//        DeviceMapper deviceMapper = (DeviceMapper)ctx.getBean("deviceMapper");
//        System.out.println(deviceMapper.queryStatus(20));
        Device device = (Device) ctx.getBean("deviceA");
        device.print();
        BeanAquire beanAquire  = new BeanAquire();
        beanAquire.print();
        ctx.publishEvent(new PrintEvent(beanAquire));

    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 初始化");
    }

     private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
    }
}
