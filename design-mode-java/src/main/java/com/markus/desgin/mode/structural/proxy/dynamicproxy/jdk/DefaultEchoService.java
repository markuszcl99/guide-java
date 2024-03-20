package com.markus.desgin.mode.structural.proxy.dynamicproxy.jdk;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/20
 * @Description:
 */
public class DefaultEchoService implements EchoService {
  @Override
  public String echo(String message) {
    return "DefaultEchoService [ " + message + " ]";
  }
}
