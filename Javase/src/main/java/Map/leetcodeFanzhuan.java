package Map;

import java.util.*;

public class leetcodeFanzhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符串");
        String str = scanner.next();
        HashMap<Integer, Character> hashMap = new HashMap<>();
        ArrayList<Integer> integers = new ArrayList<>();
        Integer i = 0;
        //循环所有字节
        for (Character c : str.toCharArray()) {
            hashMap.put(i, c);
            integers.add(i);
            i++;
        }
        Collections.sort(integers, (Integer o1, Integer o2) -> o2 - o1);
        if (hashMap.get(integers.get(0)).equals('0')){
            integers.remove(0);
        }
        for (Integer integer : integers) {
            System.out.print(hashMap.get(integer));
        }


    }

}


