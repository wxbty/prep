package ink.zfei.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {

        List<Person> list = new ArrayList();
        Person zhangsan = new Person();
        zhangsan.setAge(50);
        zhangsan.setMan(true);
        zhangsan.setName("zhangsan");

        Person zhangsan1 = new Person();
        zhangsan1.setAge(52);
        zhangsan1.setMan(true);
        zhangsan1.setName("zhangsan");

        Person lisi = new Person();
        lisi.setAge(18);
        lisi.setMan(false);
        lisi.setName("lisi");

        list.add(zhangsan);
        list.add(zhangsan1);
        list.add(lisi);
        Map<String, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getName));
        map.entrySet().parallelStream().forEach(System.out::println);
//        System.out.println(manList(list));

    }

    public static List<Demo> manList(List<Person> all) {

        return all.stream().filter(person -> person.isMan()).map(person -> new Demo()).limit(1).collect(Collectors.toList());

//        List<Person> result = new ArrayList<>();
//        for (Person person : all) {
//            if (person.isMan()) {
//                result.add(person);
//            }
//        }
//        return result;
    }

    public Demo getDemo(Demo demo) {
        return new Demo();
    }

    public List<Person> yongList(List<Person> all) {
        List<Person> result = new ArrayList<>();
        for (Person person : all) {
            if (person.getAge() < 30) {
                result.add(person);
            }
        }
        return result;
    }

}
