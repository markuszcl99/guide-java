package com.markus.desgin.mode.structural.bridge;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/12
 * @Description:
 */
public class Circle extends Shape {
  public Circle(DrawApi api) {
    super(api);
  }

  @Override
  public void draw() {
    System.out.println("Draw Circle : " + drawApi.draw());
  }
}
