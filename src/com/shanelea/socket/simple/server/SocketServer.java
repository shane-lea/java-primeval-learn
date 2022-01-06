package com.shanelea.socket.simple.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import static com.shanelea.socket.common.SocketConstant.*;

public class SocketServer {

    public static Logger log = Logger.getLogger(SocketServer.class.toString());

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(SERVER_PORT);
        /**
         * 建立server,等待客户端连接
         */
        log.info("waiting for client connect ... ");
        Socket socket = server.accept();

        /**
         * 建立好连接后,从socket中获取输入流，建立缓冲区读取数据
         */
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            /**
             * 指定编码格式 发送方和接收方统一
             */
            sb.append(new String(bytes, 0, len, CHARSET_NAME));
        }
        log.info("message from client:" + sb);
        inputStream.close();
        socket.close();
        server.close();
    }
}
