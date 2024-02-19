package com.markus.java.io.model;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: markus
 * @date: 2024/2/19 5:17 PM
 * @Description: 同步非阻塞 IO 模型示例
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class NIOModel {
    static class NIOServer {
        public static void main(String[] args) throws IOException {
            Selector serverSelector = Selector.open();
            Selector clientSelector = Selector.open();

            new Thread(() -> {
                try {
                    ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                    // 绑定端口号
                    listenerChannel.socket().bind(new InetSocketAddress(9001));
                    // 非阻塞 IO 模式
                    listenerChannel.configureBlocking(false);
                    listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

                    while (true) {
                        if (serverSelector.select(1) > 0) {
                            Set<SelectionKey> set = serverSelector.selectedKeys();
                            Iterator<SelectionKey> iterator = set.iterator();
                            while (iterator.hasNext()) {
                                SelectionKey key = iterator.next();
                                if (key.isAcceptable()) {
                                    try {
                                        SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                                        clientChannel.configureBlocking(false);
                                        clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                    } finally {
                                        iterator.remove();
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();

            new Thread(() -> {
                try {
                    while (true) {
                        if (clientSelector.select(1) > 0) {
                            Set<SelectionKey> set = clientSelector.selectedKeys();
                            Iterator<SelectionKey> iterator = set.iterator();
                            while (iterator.hasNext()) {
                                SelectionKey key = iterator.next();
                                try {
                                    if (key.isReadable()) {
                                        SocketChannel clientChannel = (SocketChannel) key.channel();
                                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                        //
                                        int read = clientChannel.read(byteBuffer);
                                        if (read == -1) {
                                            System.out.println("Client disconnected: " + clientChannel.getRemoteAddress());
                                            clientChannel.close();
                                            key.cancel();
                                            continue;
                                        }
                                        byteBuffer.flip();
                                        System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer));
                                    }
                                } finally {
                                    iterator.remove();
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    static class NIOClient {
        public static void main(String[] args) {
            new Thread(() -> {
                try {
                    SocketChannel socketChannel = SocketChannel.open();

                    socketChannel.configureBlocking(false);
                    socketChannel.connect(new InetSocketAddress("127.0.0.1", 9001));
                    while (true) {
                        while (!socketChannel.finishConnect()) {
                            System.out.println("未与服务端建立连接，重试中...");
                        }
                        // 连接成功，开始发消息
                        String message = new Date() + " Hello World!";

                        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                        while (buffer.hasRemaining()) {
                            socketChannel.write(buffer);
                        }
                        Thread.sleep(2000);
                    }
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
