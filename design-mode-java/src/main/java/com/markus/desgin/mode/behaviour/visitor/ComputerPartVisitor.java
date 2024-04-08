package com.markus.desgin.mode.behaviour.visitor;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/8
 * @Description:
 */
public interface ComputerPartVisitor {
  void visit(Computer computer);

  void visit(Keyboard keyboard);

  void visit(Mouse mouse);
}
