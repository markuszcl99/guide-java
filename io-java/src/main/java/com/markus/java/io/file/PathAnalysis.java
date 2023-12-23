package com.markus.java.io.file;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author: markus
 * @date: 2023/12/23 3:10 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class PathAnalysis {

    private static final String FILE_RELATIVE_PATH = "io-java/src/main/java/com/markus/java/io/file/PathAnalysis.java";

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(System.getProperty("os.name"));
        Path path = Paths.get(FILE_RELATIVE_PATH).toAbsolutePath();

        say("Exists", Files.exists(path));
        say("Directory", Files.isDirectory(path));
        // jvm 是否有权限 去执行该文件
        say("Executable", Files.isExecutable(path));
        say("Readable", Files.isReadable(path));
        say("RegularFile", Files.isRegularFile(path));
        say("Writable", Files.isWritable(path));
        say("notExists", Files.notExists(path));
        say("Hidden", Files.isHidden(path));
        say("size", Files.size(path));
        // 返回与 path 关联的文件存储，可以通过 FileStore 得到 文件存储的信息，例如类型、空间、总空间大小
        say("FileStore", Files.getFileStore(path));

        FileTime lastModifiedTime = Files.getLastModifiedTime(path);
        Instant instant = lastModifiedTime.toInstant();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
        say("LastModified【UTC】", lastModifiedTime);
        say("LastModified【Local】", zonedDateTime);

        // 文件创建人
        say("Owner", Files.getOwner(path));

        // 当文件类型无法确定时，将会返回 null
        say("ContentType", Files.probeContentType(path));

        // 符号链接是一种特殊类型的文件，它包含对另一个文件或目录的引用
        say("SymbolicLink", Files.isSymbolicLink(path));
        if (Files.isSymbolicLink(path)) {
            say("SymbolicLink", Files.readSymbolicLink(path));
        }
        // getPosixFilePermissions 用于获取指定路径上文件的 POSIX 文件权限。
        // POSIX 在 UNIX 或 类UNIX 操作系统中，定义了用户（owner）、组（group）和其他人对文件或目录的读、写和执行权限
        if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
            say("PosixFilePermissions", Files.getPosixFilePermissions(path));
        }
    }

    private static void say(String id, Object result) {
        System.out.print(id + " : ");
        System.out.println(result);
    }
}
