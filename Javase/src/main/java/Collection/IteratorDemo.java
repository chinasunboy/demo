package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        // 使用多态方式 创建对象
        Collection<String> collection = new ArrayList<String>();
        // 添加元素到集合
        collection.add("詹姆斯");
        collection.add("韦德");
        collection.add("保罗");
        collection.add("安东尼");
        //遍历
        //使用迭代器 遍历   每个集合对象都有自己的迭代器
        Iterator<String> iterator = collection.iterator();
        //判断是否有迭代元素
        while (iterator.hasNext()) {
            //获取迭代出的元素
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("---------------------");

        for (String n : collection){
            System.out.println(n);
        }

    }
}
