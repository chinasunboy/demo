package List;

import java.util.*;

public class h_set {
    public static void main(String[] args) {
//        HashSet<String> hashSet = new HashSet<String>();
//        hashSet.add("abc");
//        hashSet.add("bac");
//        hashSet.add("cba");
//
//        for (String n :hashSet){
//            System.out.println(n);
//        }
        HashSet<student> hashSet = new HashSet<>();
        hashSet.add(new student("大傻逼",15));
        hashSet.add(new student("中傻逼",17));
        hashSet.add(new student("小傻逼",14));
        for(student s :hashSet){
            System.out.println(s);
        }

        LinkedHashSetDemo();
    }

    public static void LinkedHashSetDemo(){
        Set<String> hashSet = new LinkedHashSet<>();
        hashSet.add("abc");
        hashSet.add("bac");
        hashSet.add("cba");
        for(String s :hashSet){
            System.out.println(s);
        }

    }
}
