package com.markus.desgin.mode.structure.proxy.staticproxy;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/19
 * @Description:
 */
public class EchoServiceProxy implements EchoService {

  private EchoService echoService;

  public EchoServiceProxy(EchoService echoService) {
    this.echoService = echoService;
  }

  @Override
  public String echo(String message) {
    String echo = echoService.echo(message);
    return "EchoServiceProxy [ " + echo + " ]";
  }
}
