package IO;

import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\02\\1.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] bytes = new byte[1024];
        int len = 0;
        long start = System.currentTimeMillis();
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
