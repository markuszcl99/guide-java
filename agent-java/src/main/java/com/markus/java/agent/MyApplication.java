package com.markus.java.agent;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/20
 * @Description:
 */
public class MyApplication {
  /**
   * 执行  java -javaagent:target/agent-java-1.0-SNAPSHOT.jar -jar target/agent-java-1.0-SNAPSHOT.jar
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("Hello,Instrumentation");
  }
}
