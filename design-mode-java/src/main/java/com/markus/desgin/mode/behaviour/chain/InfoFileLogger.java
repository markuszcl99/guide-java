package com.markus.desgin.mode.behaviour.chain;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/7
 * @Description:
 */
public class InfoFileLogger extends AbstractLogger{
  public InfoFileLogger(int level) {
    super(level);
  }

  @Override
  protected void write(String message) {
    System.out.println("InfoFileLogger : " + message);
  }
}
