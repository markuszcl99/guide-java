package com.markus.desgin.mode.behaviour;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/21
 * @Description:
 */
public class TemplateMethodPattern {
  public static void main(String[] args) {
    Game game = new SkylineGame();
    game.play();

    game = new ItTakesTwoGame();
    game.play();
  }
}
