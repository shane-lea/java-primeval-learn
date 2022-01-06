package com.shanelea.socket.advanced.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import static com.shanelea.socket.common.SocketConstant.*;

public class SocketServer {

    public static Logger log = Logger.getLogger(SocketServer.class.toString());

    public static void main(String[] args) throws Exception {


        ServerSocket server = new ServerSocket(SERVER_PORT);
        /**
         * Listens for a connection to be made to this socket and accepts it.The method blocks until a connection is made.
         * 服务端一直等待连接的到来
         */
        Socket socket = server.accept();
        /**
         * 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
         */
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        /**
         * 只有当客户端关闭它的输出流的时候，服务端才能取得结尾的-1
         */
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, CHARSET_NAME));
        }
        log.info("message from client: " + sb);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("tell client,I got message.".getBytes());

//        inputStream.close();
//        outputStream.close();
//        socket.close();
//        server.close();

    }
}
