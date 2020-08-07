package ink.zfei.staticproxy;

public class UserRule implements Rule{
    public String explain(String param) {
        System.out.println("解析会员活动规则="+param);
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


}
