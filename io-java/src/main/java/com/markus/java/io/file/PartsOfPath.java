package com.markus.java.io.file;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: markus
 * @date: 2023/12/23 1:50 PM
 * @Description: 剖析 Path 对象路径的各个部分
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class PartsOfPath {

    private static final String FILE_RELATIVE_PATH = "/io-java/src/main/java/com/markus/java/io/file/PartsOfPath.java";

    public static void main(String[] args) {
        Path path = Paths.get(FILE_RELATIVE_PATH);

        // 路径与平台无关
        Path absolutePath = path.toAbsolutePath();
        for (int i = 0; i < absolutePath.getNameCount(); i++) {
            System.out.println(absolutePath.getName(i));
        }

        // 以一个独立的 part 去判断，例如 当前 path 判断以 PartsOfPath.java 为结尾则为 true，否则则为 false
        System.out.println("ends with '.java' : " + absolutePath.endsWith(".java"));

        for (Path part : absolutePath) {
            System.out.print(part + ": ");
            System.out.print(absolutePath.startsWith(part) + " : ");
            System.out.println(absolutePath.endsWith(part) + " : ");
        }
    }
}
