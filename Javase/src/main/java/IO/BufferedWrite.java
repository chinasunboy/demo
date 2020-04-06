package IO;

import java.io.*;

public class BufferedWrite {
    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\Bwio.txt"));
//        bufferedWriter.write("大傻逼");
//        bufferedWriter.close();
        BufferedReader bufferedReader = new BufferedReader
                (new FileReader("C:\\\\Users\\\\你不懂\\\\Desktop\\\\SSM笔记\\\\测试\\\\Bwio.txt"));
        String len;
        while ((len=bufferedReader.readLine())!=null){
            System.out.println(len);
        }
        bufferedReader.close();
    }
}