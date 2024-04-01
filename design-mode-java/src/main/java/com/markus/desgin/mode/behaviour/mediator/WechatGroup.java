package com.markus.desgin.mode.behaviour.mediator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/1
 * @Description: 微信群
 */
public class WechatGroup {
  public static void showMessage(User user, String message) {
    System.out.println("User [" + user.getUsername() + "] send message : " + message);
  }
}
