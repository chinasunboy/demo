package TCP;

import java.io.*;
import java.net.Socket;

public class FileUPload_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\你不懂\\Desktop\\SSM笔记\\企业.txt"));
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes = new byte[1024];
        int len =0;
        while ((len=bufferedInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
        }
        //标记停止
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        while ((len = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }


        bufferedInputStream.close();
        outputStream.close();
        socket.close();

    }
}
