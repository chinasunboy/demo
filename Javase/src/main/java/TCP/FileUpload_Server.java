package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUpload_Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器 启动.....  ");
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\你不懂\\Desktop\\SSM笔记\\测试\\企业.txt"));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(accept.getInputStream());
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,len);
        }
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("上传成功！".getBytes());

        bufferedInputStream.close();
        outputStream.close();
        bufferedOutputStream.close();
        accept.close();


    }
}
