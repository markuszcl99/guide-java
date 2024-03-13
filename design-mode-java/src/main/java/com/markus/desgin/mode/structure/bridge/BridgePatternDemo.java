package com.markus.desgin.mode.structure.bridge;

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
    Shape red = new Circle(new RedCircleDraw());
    Shape blue = new Circle(new BlueCircleDraw());

    red.draw();
    blue.draw();
  }
}
