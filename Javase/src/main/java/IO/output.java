package IO;

import java.io.FileOutputStream;
import java.io.IOException;

public class output {
    public static void main(String[] args) throws IOException {
        //public FileOutputStream(String name, boolean append)
        //参数中都需要传入一个boolean类型的值， true 表示追加数据， false 表示清空原有数据
        FileOutputStream fileOutputStream =
                new FileOutputStream("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\io.txt", false);
        fileOutputStream.write("大傻逼".getBytes());
        fileOutputStream.write("\r\n".getBytes());
        fileOutputStream.write("大傻逼".getBytes());
        fileOutputStream.write("\r\n".getBytes());
        byte[] a={49,48,48};
        fileOutputStream.write(a);
        fileOutputStream.close();
    }
}
