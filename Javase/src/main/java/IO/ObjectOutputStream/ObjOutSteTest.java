package IO.ObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

public class ObjOutSteTest {
    public static void main(String[] args) throws Exception {
        //objectOutput();
        objectInput();

    }



    private static void objectOutput() throws IOException {
        ArrayList<student> objects = new ArrayList<>();
        objects.add(new student("大傻逼",18));
        objects.add(new student("二傻逼",19));
        objects.add(new student("三傻逼",20));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream
                (new FileOutputStream("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\ObjectOutputStream.txt"));
        objectOutputStream.writeObject(objects);
        objectOutputStream.close();
    }
    private static void objectInput() throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream
                (new FileInputStream("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\ObjectOutputStream.txt"));
        Object o = objectInputStream.readObject();
        ArrayList<student> s = ( ArrayList<student>)o;
        for (student st :s){
            System.out.println(st);
        }
      objectInputStream.close();
    }
}
