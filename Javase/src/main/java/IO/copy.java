package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copy {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\02\\1.jpg");
        long l = System.currentTimeMillis();
        //byte[] bytes = new byte[1024];
        int len =0;
        while ((len=fileInputStream.read())!=-1){
            fileOutputStream.write(len);
        }
        fileInputStream.close();
        fileOutputStream.close();
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }
}
