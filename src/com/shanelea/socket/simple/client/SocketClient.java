package com.shanelea.socket.simple.client;

import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

import static com.shanelea.socket.common.SocketConstant.*;

public class SocketClient {

    public static Logger log = Logger.getLogger(SocketClient.class.toString());

    public static void main(String[] args) throws Exception {

        /**
         * 和服务端建立连接
         */
        Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        /**
         * 建立连接后获得输出流
         */
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好 ShaneLea";
        socket.getOutputStream().write(message.getBytes(CHARSET_NAME));
        outputStream.close();
        socket.close();

    }
}
