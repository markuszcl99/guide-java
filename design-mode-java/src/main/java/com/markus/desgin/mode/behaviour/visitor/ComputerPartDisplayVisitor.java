package com.markus.desgin.mode.behaviour.visitor;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/8
 * @Description:
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor{

  @Override
  public void visit(Computer computer) {
    System.out.println("computer display....");
  }

  @Override
  public void visit(Keyboard keyboard) {
    System.out.println("keyboard display....");
  }

  @Override
  public void visit(Mouse mouse) {
    System.out.println("mouse display....");
  }
}
