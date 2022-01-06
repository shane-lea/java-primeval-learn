package com.shanelea.socket.advanced.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

import static com.shanelea.socket.common.SocketConstant.*;

public class SocketClient {

    public static Logger log = Logger.getLogger(SocketClient.class.toString());

    public static void main(String[] args) throws Exception {

        /**
         * 与服务端建立连接
         */
        Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

        String message = "你好  ShaneLea";
        /**
         * 建立连接后获得输出流
         */
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message.getBytes());
        /**
         * 通过shutdownOutput 高速服务器已经发送完数据，后续只能接受数据
         */
        socket.shutdownOutput();

        byte[] bytes = new byte[1024];
        int len;
        InputStream inputStream = socket.getInputStream();
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, CHARSET_NAME));
        }
        log.info("message from server: " + sb);

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
