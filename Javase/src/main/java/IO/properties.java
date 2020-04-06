package IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class properties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
//        properties.setProperty("大傻逼","173");
//        properties.setProperty("二傻逼","168");
//        FileWriter fileWriter = new FileWriter("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\properties.txt");
//        properties.store(fileWriter,"write");
//        fileWriter.close();
        FileReader fileReader = new FileReader("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\properties.txt");
        properties.load(fileReader);
        Set<String> strings = properties.stringPropertyNames();
        for (String s :strings){
            System.out.println(properties.get(s));
        }
        fileReader.close();
    }
}
