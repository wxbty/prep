package ink.zfei.spring.listener;

import org.springframework.context.ApplicationEvent;

public class PrintEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PrintEvent(Object source) {


        super(source);
        String uid = "1140";

    }
}
