package com.markus.desgin.mode.behaviour.interpreter;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/3
 * @Description:
 */
public class AndExpression implements Expression {

  final Expression expressionA;
  final Expression expressionB;

  public AndExpression(Expression expressionA, Expression expressionB) {
    this.expressionA = expressionA;
    this.expressionB = expressionB;
  }

  @Override
  public boolean interpreter(String context) {
    return expressionA.interpreter(context) && expressionB.interpreter(context);
  }
}
