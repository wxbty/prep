package ink.zfei.lambda;

public class Person {

    private boolean isMan;

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "isMan=" + isMan +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
