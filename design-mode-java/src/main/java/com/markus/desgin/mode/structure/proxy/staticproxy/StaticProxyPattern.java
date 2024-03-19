package com.markus.desgin.mode.structure.proxy.staticproxy;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/19
 * @Description:
 */
public class StaticProxyPattern {
  public static void main(String[] args) {
    EchoService echoService = new DefaultEchoService();
    EchoServiceProxy proxy = new EchoServiceProxy(echoService);
    String echo = proxy.echo("Hello, Static Proxy!");
    System.out.println(echo);
  }
}
