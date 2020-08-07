package ink.zfei.staticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RuleInvocationHandler implements InvocationHandler {

    private Object rule;

    public RuleInvocationHandler(Object rule) {
        this.rule = rule;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        if ("explain".equals(method.getName())) {
            System.out.println(method.getName());
            System.out.println("规则解析开始，参数=" + args[0]);
            Object result = method.invoke(rule, args);
            System.out.println("规则解析结束，返回=" + result);
            return result;
        } else {
            return method.invoke(rule, args);
        }


    }
}
