package ink.zfei.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

public class MapperProxyBeanfactoryProcessor implements BeanDefinitionRegistryPostProcessor {

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        //通过 scan ，如果有@Maaper注解，就回把Mapper的bean定义拿出来

        BeanDefinitionBuilder builder =  BeanDefinitionBuilder.genericBeanDefinition(MapperProxyFactoryBean.class);

        beanDefinitionRegistry.registerBeanDefinition("test",builder.getBeanDefinition());
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
