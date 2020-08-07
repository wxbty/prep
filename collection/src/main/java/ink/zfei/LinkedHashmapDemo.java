package ink.zfei;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashmapDemo {



    public static void main(String[] args) {

        float load = (float) 0.75;
        java.util.LinkedHashMap<String, String> map = new java.util.LinkedHashMap(16,load,true);

        map.put("zhangsan", "11");
        map.put("lisi", "22");
        map.put("wangwu", "33");
        map.put("zhaoliu", "44");
        map.get("lisi");

        //ListedList
        Iterator<Map.Entry<String,String> > it = map.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String,String> entry  = it.next();
            String key = entry.getKey();
            String val = entry.getValue();
            System.out.println("key=" + key + ",value=" + val);
        }

//        for (String key : map.keySet()) {
//
//            String val = map.get(key);
//            System.out.println("key=" + key + ",value=" + val);
//
//        }




        //zhangsan->lisi->wangwuu

    }


}
