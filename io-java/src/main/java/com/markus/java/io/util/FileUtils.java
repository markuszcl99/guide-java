package com.markus.java.io.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author: markus
 * @date: 2024/6/8 12:56 PM
 * @Description: 目录工具类
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public abstract class FileUtils {

    /**
     * 删除指定的目录
     *
     * @param dir
     */
    public static void rmDir(Path dir) throws IOException {
        // walkFileTree 查找每个子目录和文件
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * 清空指定目录
     * @param path
     * @throws IOException
     */
    public static void refreshDir(Path path) throws IOException {
        if (Files.exists(path)) {
            rmDir(path);
        }
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
    }
}
