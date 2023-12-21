package com.markus.java.io;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: markus
 * @date: 2023/12/21 11:01 PM
 * @Description: Path 使用示例
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class PathApiDemo {

    private static final String CURRENT_FILE_PATH = "/io-java/src/main/java/com/markus/java/io/PathApiDemo.java";

    private static final String FILE_TXT_PATH = "/io-java/src/main/resources/META-INF/file.txt";

    /**
     * Path 知识点总结:
     * <p>
     * 1. Path 和 File 的区别：<p>
     * 1.1 Path 属于 Java NIO 2 （since 1.7）而 File 属于 Java IO ，Path 是更现代化的、更灵活的处理文件路径的方式，它是在不同操作系统和文件系统之上的抽象
     * 1.2
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));
        String rootPath = System.getProperty("user.dir");
        info(Paths.get(rootPath + CURRENT_FILE_PATH));

        Path path = Paths.get(rootPath + FILE_TXT_PATH);
        info(path);

        Path ap = path.toAbsolutePath();
        info(ap);

        info(ap.getParent());

        info(path.toRealPath());

        URI uri = path.toUri();
        System.out.println("URI:\n" + uri);
        Path pathByUri = Paths.get(uri);
        System.out.println(Files.exists(pathByUri));
        File file = ap.toFile();
        System.out.println(file.getName());
    }

    private static String getContent(Reader reader) {
        try {
            return IOUtils.toString(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void info(Path path) {
        show("toString: \n", path);
        show("Exist: ", Files.exists(path));
        // note : regular file 具有这些特征 （内容可变性、数据存储、不是目录、不是特殊文件《设备文件、管道、符号链接》）
        show("RegularFile: ", Files.isRegularFile(path));
        show("Directory: ", Files.isDirectory(path));
        show("Absolute: ", path.isAbsolute());
        show("FileName: ", path.getFileName());
        show("Parent: ", path.getParent());
        show("Root: ", path.getRoot());
        System.out.println("*****************************");
    }

    private static void show(String id, Object obj) {
        System.out.println(id + obj);
    }
}
