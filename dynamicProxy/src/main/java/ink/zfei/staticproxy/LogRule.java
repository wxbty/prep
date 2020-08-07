package ink.zfei.staticproxy;

public class LogRule implements Rule {

    private Rule rule;

    LogRule(Rule rule) {
        this.rule = rule;
    }

    public String explain(String param) {

        System.out.println("规则解析开始，参数=" + param);
        String result = rule.explain(param);
        System.out.println("规则解析结束，返回=" + param);
        return result;
    }

    public void m1(String name) {
        this.rule.m1(name);
    }

    public void m2() {
        this.rule.m2();
    }

    public void m3() {
        this.rule.m3();

    }

    public void m4() {
        this.rule.m4();

    }
}
