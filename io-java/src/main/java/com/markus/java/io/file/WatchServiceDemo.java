package com.markus.java.io.file;

import com.markus.java.io.util.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * @author: markus
 * @date: 2024/6/8 12:48 PM
 * @Description: 文件监听示例
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class WatchServiceDemo {
    private static String CURRENT_PATH = System.getProperty("user.dir");

    private static Path test = Paths.get(CURRENT_PATH + "/io-java/src/main/resources/META-INF/test");

    private static void deleteFiles() {
        try {
            Files.walk(test)
                    .filter(f -> f.toString().endsWith(".txt"))
                    .forEach(f -> {
                        try {
                            System.out.println("deleting " + f);
                            Files.delete(f);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        FileUtils.refreshDir(test);

        Files.createFile(test.resolve("Hello.txt"));

        WatchService watcher = FileSystems.getDefault().newWatchService();
//        test.register(watcher, ENTRY_DELETE);
//        Executors.newSingleThreadScheduledExecutor()
//                .schedule(
//                        WatchServiceDemo::deleteFiles, 250, TimeUnit.MILLISECONDS
//                );
        // 注册文件修改监听
        test.register(watcher, ENTRY_MODIFY);

        // 阻塞等待
        WatchKey key = watcher.take();
        for (WatchEvent<?> event : key.pollEvents()) {
            System.out.println("evt.context(): " + event.context() +
                    "\nevt.count(): " + event.count() +
                    "\nevt.kind(): " + event.kind());
            // 将相对路径转为绝对路径
            Path file = test.resolve((Path) event.context());
            List<String> fileContent = Files.readAllLines(file);
            // 打印文件内容
            for (String line : fileContent) {
                System.out.println(line);
            }
            System.exit(0);
        }
    }
}
