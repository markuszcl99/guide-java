package com.markus.java.agent;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/20
 * @Description:
 */
public class MyApplication {
  /**
   * 执行  java -javaagent:target/agent-java-1.0-SNAPSHOT.jar -jar target/agent-java-1.0-SNAPSHOT.jar 会执行代理
   * 执行 jar tf target/agent-java-1.0-SNAPSHOT.jar 查看 jar 包中的文件
   * 执行 unzip -p target/agent-java-1.0-SNAPSHOT.jar META-INF/MANIFEST.MF 查看指定文件的内容
   *      unzip是一个用于解压缩ZIP压缩文件的命令行工具。
   *      -p选项在unzip命令中的含义是将指定的文件解压到标准输出（通常是终端或控制台）。
   *      这个选项通常被用来查看ZIP文件中的文件内容而不实际解压文件到磁盘上。
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("Hello,Instrumentation");
  }
}
