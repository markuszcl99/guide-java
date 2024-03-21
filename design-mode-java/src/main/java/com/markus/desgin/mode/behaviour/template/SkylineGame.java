package com.markus.desgin.mode.behaviour.template;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/21
 * @Description:
 */
public class SkylineGame extends AbstractGame {
  @Override
  protected void startGame() {
    System.out.println("地平线游戏启动了...");
  }

  @Override
  protected void playGame() {
    System.out.println("地平线游戏开始了...");
  }

  @Override
  protected void endGame() {
    System.out.println("地平线游戏结束了...");
  }
}
