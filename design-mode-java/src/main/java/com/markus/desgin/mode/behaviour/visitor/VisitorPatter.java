package com.markus.desgin.mode.behaviour.visitor;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/8
 * @Description:
 */
public class VisitorPatter {
  public static void main(String[] args) {
    Computer computer = new Computer();
    computer.accept(new ComputerPartDisplayVisitor());
  }
}
