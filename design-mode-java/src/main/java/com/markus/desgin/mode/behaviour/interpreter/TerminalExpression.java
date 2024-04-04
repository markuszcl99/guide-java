package com.markus.desgin.mode.behaviour.interpreter;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/3
 * @Description:
 */
public class TerminalExpression implements Expression {
  private String data;

  public TerminalExpression(String data) {
    this.data = data;
  }


  @Override
  public boolean interpreter(String context) {
    return context.contains(data);
  }
}
