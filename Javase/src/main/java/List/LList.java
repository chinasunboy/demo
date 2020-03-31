package List;

import java.util.Collections;
import java.util.LinkedList;

public class LList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("2大傻逼");
        linkedList.addFirst("3小煞笔");
        linkedList.addLast("1大大傻逼");

        Collections.sort(linkedList);
        System.out.println(linkedList);
        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.isEmpty());
        String s = linkedList.removeFirst();
        String s1 = linkedList.removeLast();
        System.out.println(s+"  "+s1);
        System.out.println(linkedList);

    }
}
