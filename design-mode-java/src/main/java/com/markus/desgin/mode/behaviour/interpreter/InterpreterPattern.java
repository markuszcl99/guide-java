package com.markus.desgin.mode.behaviour.interpreter;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/3
 * @Description:
 */
public class InterpreterPattern {

  // 规则一：markus and luna 都是山东人
  private static Expression hometownFromShandong() {
    Expression markus = new TerminalExpression("markus");
    Expression luna = new TerminalExpression("luna");
    return new OrExpression(markus, luna);
  }

  // 规则二：luna 是 00 后 女生
  private static Expression femaleBornAfter2000() {
    Expression markus = new TerminalExpression("luna");
    Expression luna = new TerminalExpression("female born after 2000");
    return new AndExpression(markus, luna);
  }


  public static void main(String[] args) {
    Expression expression = hometownFromShandong();
    System.out.println("markus is from shandong province : " + expression.interpreter("markus is from shandong province?"));
    expression = femaleBornAfter2000();
    System.out.println("luna born after 2000 : " + expression.interpreter("Is luna a female born after 2000?"));
  }
}
