package Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Poker {
    public static void main(String[] args) {
        //存储牌的map
        HashMap<Integer,String> poker = new HashMap<>();
        //牌的map索引
        ArrayList<Integer> index = new ArrayList<>();
        //花色
        ArrayList<String> colors = new ArrayList<String>();
        //数字
        ArrayList<String> numbers = new ArrayList<String>();
        Collections.addAll(colors, "♦", "♣", "♥", "♠");
        Collections.addAll(numbers, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        //将牌存进map跟list中
        int count = 1;
        index.add(count);
        poker.put(count++,"大王");
        index.add(count);
        poker.put(count++,"小王");
        for (String s : numbers){
            for (String t : colors){
                String card = s+t;
                index.add(count);
                poker.put(count++,card);
            }
        }
//        System.out.println(poker);
//        System.out.println(index);
        //打乱索引
        Collections.shuffle(index);
       // System.out.println(index);
        //定义玩家牌的索引集合
        ArrayList<Integer> noP1 = new ArrayList<Integer>();
        ArrayList<Integer> noP2 = new ArrayList<Integer>();
        ArrayList<Integer> noP3 = new ArrayList<Integer>();
        ArrayList<Integer> dipaiNo = new ArrayList<Integer>();

        //给玩家分配索引，就是发牌
        for (Integer i =0;i<index.size();i++ ){
            Integer integer = index.get(i);
            if (i>=51){
                dipaiNo.add(integer);
            }if(i%3==0){
                noP1.add(integer);
            }if(i%3==1){
                noP2.add(integer);
            }if(i%3==2){
                noP3.add(integer);
            }
        }

        //将索引排序
        Collections.sort(noP1);
        Collections.sort(noP2);
        Collections.sort(noP3);
        Collections.sort(dipaiNo);

        //调用自定义看牌方法
        lookPoker("大傻逼",poker,noP1);
        lookPoker("二傻逼",poker,noP2);
        lookPoker("三傻逼",poker,noP3);
        lookPoker("底牌",poker,dipaiNo);

    }

    public static void  lookPoker(String name,HashMap<Integer,String> pokee,ArrayList<Integer> list){
        System.out.println(name+":");
        //根据玩家索引看牌
        for (Integer k : list){
            System.out.print(pokee.get(k)+" ");
        }
        System.out.println();
    }
}
