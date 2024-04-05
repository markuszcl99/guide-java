package com.markus.desgin.mode.structural.bridge;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/12
 * @Description:
 */
public class BridgePatternDemo {
  /**
   * Spring 中 JdbcTemplate 和 DataSource 之间的关系就是一种 桥接模式
   * @param args
   */
  public static void main(String[] args) {

    RedDraw redDraw = new RedDraw();
    BlueDraw blueDraw = new BlueDraw();

    Shape red = new Circle(redDraw);
    Shape blue = new Circle(blueDraw);
    red.draw();
    blue.draw();

    red = new Square(redDraw);
    blue = new Square(blueDraw);
    red.draw();
    blue.draw();
  }
}
