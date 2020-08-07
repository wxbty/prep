package demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class UpdateBeanDefinationProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("deviceA");
//        beanDefinition.setBeanClassName("ink.zfei.spring.ioc.User");

        //获取所有bean定义

        //遍历，查看所有依赖的属性，是否有#{}这种占位符

        //如果有的话，从config里面获取所有key,value集合 或者从http服务器获取最新的配置

        //根据#{}里面的key，去config集合里找到value

        //替换bean定义

    }
}
