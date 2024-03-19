package com.markus.desgin.mode.structure.proxy.staticproxy;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/19
 * @Description:
 */
public class DefaultEchoService implements EchoService {
  @Override
  public String echo(String message) {
    return "DefaultEchoService [ " + message + " ]";
  }
}
