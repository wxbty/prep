package ink.zfei.spring.ioc;

public class User {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "ink.zfei.spring.ioc.User{" +
                "name='" + name + '\'' +
                '}';
    }
}
