package IO;

import java.io.*;

public class bufferIO {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("C:\\\\Users\\\\你不懂\\\\Desktop\\\\SSM笔记\\\\测试\\Bufferedio.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }

        bufferedInputStream.close();
        fileInputStream.close();
    }
}