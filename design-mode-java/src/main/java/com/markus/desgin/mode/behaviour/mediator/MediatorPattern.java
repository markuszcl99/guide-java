package com.markus.desgin.mode.behaviour.mediator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/1
 * @Description: 中介者模式
 */
public class MediatorPattern {
  public static void main(String[] args) {
    User user = new User("markuszhang");
    user.sendMessage("Hello, Mediator");
  }
}
