package com.markus.desgin.mode.behaviour.visitor;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/8
 * @Description:
 */
public class Mouse implements ComputerPart{
  @Override
  public void accept(ComputerPartVisitor visitor) {
    visitor.visit(this);
  }
}
