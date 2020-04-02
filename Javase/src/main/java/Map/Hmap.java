package Map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Hmap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符串");
        String str = scanner.next();
        HashMap<Character,Integer> hashMap = new HashMap<>();
        Integer num=1;
        for (Character c :str.toCharArray()){
            if (hashMap.get(c) == null){
                hashMap.put(c,num);
            }else{
                Integer integer = hashMap.get(c);
                hashMap.put(c,++integer);
            }
        }
        System.out.println(hashMap);
        Set<Character> characters = hashMap.keySet();
        for (Character c :characters){
            System.out.print(c+" ");
            System.out.println(hashMap.get(c));
        }
    }
}
