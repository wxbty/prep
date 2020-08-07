package ink.zfei.staticproxy;

import java.lang.reflect.Proxy;

public class ActivityRule  implements Rule{
    public String explain(String param) {

        System.out.println("解析活动规则="+param);
        return param;
    }

    public void m1(String name) {

    }

    public void m2() {

    }

    public void m3() {

    }

    public void m4() {

    }


    public static void main(String[] args) {
//        Rule rule = new ActivityRule();
//       String result = rule.explain("大转盘 ");

//        Rule rule =  new LogRule(new ActivityRule());
//        String result =  rule.explain("大转盘");
//        rule.m1();
//
//        Rule rule1 =  new LogRule(new UserRule());
//        rule1.explain("黄金会员");

        RuleInvocationHandler invocationHandler = new RuleInvocationHandler(new ActivityRule());

        Rule rule = (Rule)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{Rule.class},invocationHandler);

//        rule.explain("大转盘");
         rule.m1("m1");

    }
}
