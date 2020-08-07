package ink.zfei.spring.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class PrintAfterRefreshEventListener  implements ApplicationListener<PrintEvent>  {
    @Override
    public void onApplicationEvent(PrintEvent event) {
        System.out.println("容器刷新完了。。。。。");
    }
    
}
