package IO.InputStreamReader;

import java.io.*;

public class InputRW {
    public static void main(String[] args) throws IOException {

        inputIo();
        //outputIo();

    }



    private static void outputIo() throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter
                (new FileOutputStream("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\inpurio.txt"),"GBK");
        outputStreamWriter.write("大傻逼");
        outputStreamWriter.close();
    }

    private static void inputIo() throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader
                (new FileInputStream("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\inpurio.txt"), "GBK");
//        BufferedReader inputStreamReader = new BufferedReader
//                (new FileReader("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\inpurio.txt"));

        int len =0;
        while ((len = inputStreamReader.read())!=-1){
            System.out.print((char) len);
        }
        inputStreamReader.close();
    }
}
