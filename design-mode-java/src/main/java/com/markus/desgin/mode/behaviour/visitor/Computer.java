package com.markus.desgin.mode.behaviour.visitor;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/8
 * @Description:
 */
public class Computer implements ComputerPart {

  ComputerPart[] parts;

  public Computer() {
    parts = new ComputerPart[]{new Mouse(), new Keyboard()};
  }

  @Override
  public void accept(ComputerPartVisitor visitor) {
    for (ComputerPart part : parts) {
      part.accept(visitor);
    }
    visitor.visit(this);
  }
}
