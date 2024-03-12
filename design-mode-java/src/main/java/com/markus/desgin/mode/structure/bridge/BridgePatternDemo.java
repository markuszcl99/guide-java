package com.markus.desgin.mode.structure.bridge;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/12
 * @Description:
 */
public class BridgePatternDemo {
  public static void main(String[] args) {
    Shape red = new Circle(new RedCircleDraw());
    Shape blue = new Circle(new BlueCircleDraw());

    red.draw();
    blue.draw();
  }
}
