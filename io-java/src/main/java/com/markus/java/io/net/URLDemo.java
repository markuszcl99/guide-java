package com.markus.java.io.net;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: markus
 * @date: 2023/12/23 1:26 PM
 * @Description: URL 使用示例
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 * @see URI
 */
public class URLDemo {

    private static final String CURRENT_FILE_PATH = "/io-java/src/main/java/com/markus/java/io/net/URLDemo.java";

    private static final String FILE_PROTOCOL = "file://";

    public static void main(String[] args) throws URISyntaxException, IOException {
        String userDir = System.getProperty("user.dir");

        URL url = new URL(FILE_PROTOCOL + userDir + CURRENT_FILE_PATH);
        System.out.println(url);

        URI uri = url.toURI();
        Path path = Paths.get(uri);
        File file = path.toFile();
        String content = IOUtils.toString(new FileReader(file));
        System.out.println(content);

    }
}
