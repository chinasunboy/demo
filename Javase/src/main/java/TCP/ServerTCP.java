package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器
public class ServerTCP {
    public static void main(String[] args) throws IOException {

        System.out.println("服务端启动 , 等待连接 .... ");
        ServerSocket server = new ServerSocket(6666);
        Socket socket = server.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String s = new String(bytes,0,len);
        System.out.println(s);


        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务器已收到".getBytes());

        socket.close();
        inputStream.close();

    }
}
