package Thread.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("大傻逼",18),
                new Person("中傻逼",15),
                new Person("小傻逼",16)
        };
//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        });
        Arrays.sort(arr,(Person f,Person w)->{
            return w.getAge()-f.getAge();
        });
        //Arrays.sort(arr,(Person o1, Person o2)->{ return o1.getAge()-o2.getAge();});
        for (Person p :arr){
            System.out.println(p);
        }
    }
}
