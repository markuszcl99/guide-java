package com.markus.desgin.mode.structural.facade;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/15
 * @Description:
 */
public class Chef {
  public String cook(String disName) {
    System.out.println("厨师炒菜: " + disName);
    return disName + " 成品";
  }
}
