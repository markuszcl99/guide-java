package com.markus.desgin.mode.behaviour.template;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/21
 * @Description:
 */
public class TemplateMethodPattern {
  /**
   * 使用场景：当多个类有共同使用的方法时可以考虑；父类定义行为，子类定义实现
   * 优点：
   *  1. 封装不变部分，扩展可变部分
   *  2. 实现共同代码统一维护
   *  3. 由父类控制行为，子类实现
   * 缺点：
   *  1. 功能越多，子类越多
   * @param args
   */
  public static void main(String[] args) {
    Game game = new SkylineGame();
    game.play();

    game = new ItTakesTwoGame();
    game.play();
  }
}
