package com.markus.desgin.mode.behaviour;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/21
 * @Description: 双人成行
 */
public class ItTakesTwoGame extends AbstractGame {
  @Override
  protected void startGame() {
    System.out.println("双人成行游戏启动了...");
  }

  @Override
  protected void playGame() {
    System.out.println("双人成行游戏开始了...");
  }

  @Override
  protected void endGame() {
    System.out.println("双人成行游戏结束了...");
  }
}
