package com.markus.java.io.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author: markus
 * @date: 2024/2/19 3:39 PM
 * @Description: 同步阻塞 IO 模型示例
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class BIOModel {
    static class IOClient {
        public static void main(String[] args) {
            // 模拟 客户端 socket 连接
            new Thread(() -> {
                try (Socket socket = new Socket("127.0.0.1", 9001)) {
                    while (true) {
                        socket.getOutputStream().write((new Date() + " : Hello World !").getBytes());
                        Thread.sleep(2000);
                    }
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    static class IOServer {
        public static void main(String[] args) throws IOException {
            // 创建一个 serverSocket 连接
            ServerSocket serverSocket = new ServerSocket(9001);

            // 模拟一个线程 处理所有client socket 连接
            new Thread(() -> {
                while (true) {
                    try {
                        // 监听端口号，阻塞获取 socket 连接
                        Socket socket = serverSocket.accept();

                        // 每监听到一个连接，就创建一个线程去处理该连接
                        new Thread(() -> {
                            int len;
                            byte[] buffer = new byte[1024];
                            try {
                                InputStream inputStream = socket.getInputStream();
                                while ((len = inputStream.read(buffer)) != -1) {
                                    System.out.println(new String(buffer, 0, len));
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }).start();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }
}
