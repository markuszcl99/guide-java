package com.markus.java.io.file;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: markus
 * @date: 2023/12/21 11:34 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class RelativePathDemo {

    public static final String RELATIVE_PATH = "io-java/src/main/java/com/markus/java/io/RelativePathDemo.java";

    public static void main(String[] args) throws IOException {
        // 相对路径 是基于 当前工作目录，而当前的工作目录可以通过 System.getProperty("user.dir") 来查看
        Path path = Paths.get(RELATIVE_PATH);

        File file = path.toFile();
        System.out.println(IOUtils.toString(new FileReader(file)));
    }
}
