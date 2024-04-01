package com.markus.desgin.mode.behaviour.mediator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/1
 * @Description:
 */
public class User {
  private String username;

  public User() {
  }

  public User(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void sendMessage(String message) {
    WechatGroup.showMessage(this, message);
  }
}
