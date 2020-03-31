package List;

import java.util.ArrayList;
import java.util.List;

public class AList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("大傻逼");
        list.add("中傻逼");
        list.add("小傻逼");

        System.out.println(list);
        list.add(1,"小一点的傻逼");
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        String s = list.get(0);
        System.out.println(s);
        list.set(2,"小小傻逼");
        System.out.println(list);
    }
}
