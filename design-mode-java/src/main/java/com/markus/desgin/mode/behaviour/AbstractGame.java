package com.markus.desgin.mode.behaviour;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/21
 * @Description:
 */
public abstract class AbstractGame implements Game{
  /**
   * 玩游戏
   */
  public final void play() {
    // 启动游戏
    startGame();
    // 开始玩
    playGame();
    // 停止游戏
    endGame();
  }

  protected abstract void startGame();

  protected abstract void playGame();

  protected abstract void endGame();
}
