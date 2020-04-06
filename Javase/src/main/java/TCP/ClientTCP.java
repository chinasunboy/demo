package TCP;
//客户端

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) throws IOException {

        System.out.println("客户端 发送数据");
        Socket localhost = new Socket("localhost",6666);


        OutputStream outputStream = localhost.getOutputStream();
        outputStream.write("客户端发送数据".getBytes());

        InputStream inputStream = localhost.getInputStream();

        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));

        inputStream.close();
        outputStream.close();
        localhost.close();

    }

}
