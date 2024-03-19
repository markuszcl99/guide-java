package com.markus.desgin.mode.structural.bridge;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/12
 * @Description:
 */
public abstract class Shape {
  protected final DrawApi drawApi;

  public Shape(DrawApi api) {
    this.drawApi = api;
  }

  public abstract void draw();
}
