package IO.Buffered;

import java.io.*;
import java.util.HashMap;

public class iosort {
    public static void main(String[] args) throws IOException {
        //创建Map集合用来进行文本序号排序
        HashMap<String, String> HashMap = new HashMap<>();
        //字符缓冲输入流
        BufferedReader bufferedReader = new BufferedReader
                (new FileReader("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\Bwio.txt"));
        //字符缓冲输出流
        BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\Bwcopy.txt"));
        //文本
        String len;
        //读取每行文本
        while ((len = bufferedReader.readLine()) != null) {
            //文本逗号分隔
            String[] split = len.split("\\.");
            //0为序号，1为内容
            HashMap.put(split[0], split[1]);
        }
        //递归Map数组，key自动按照升序排序。用输出流写入硬盘
        for (String key : HashMap.keySet()) {
            String s = HashMap.get(key);
            len = key + "." + s;
            bufferedWriter.write(len);
            bufferedWriter.newLine();
        }
        //关闭流
        bufferedReader.close();
        bufferedWriter.close();
    }
}
