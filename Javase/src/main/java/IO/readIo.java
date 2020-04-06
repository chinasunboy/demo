package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class readIo {
    public static void main(String[] args) throws Exception {
        //字符流无法复制非文本文件
        FileReader fileReader = new FileReader("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\1.jpg");
        FileWriter fileWriter = new FileWriter("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\02\\1.jpg");
        try (fileReader;fileWriter){
            int len =0;
            while ((len = fileReader.read())!=-1){
                fileWriter.write(len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
