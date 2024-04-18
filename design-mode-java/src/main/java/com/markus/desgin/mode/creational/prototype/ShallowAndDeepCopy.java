package com.markus.desgin.mode.creational.prototype;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/18
 * @Description:
 */
public class ShallowAndDeepCopy {

  public static void main(String[] args) throws CloneNotSupportedException {
    // 测试 浅拷贝与深拷贝 的坑
    testCopy();
  }

  /**
   * object.clone 默认是浅拷贝，如果要实现深拷贝，需要开发者覆盖 clone() 方法
   *
   * @throws CloneNotSupportedException
   */
  public static void testCopy() throws CloneNotSupportedException {
    B b = new B("markuszhang");
    A a = new A(b);

    A aClone = (A) a.clone();
    System.out.println(aClone.getB() == b);
  }


  static class A implements Cloneable {
    B b;

    public A(B b) {
      this.b = b;
    }

    public B getB() {
      return b;
    }

    public void setB(B b) {
      this.b = b;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//      修改前的克隆
//      return super.clone();
      A clone = (A) super.clone();
      // 不使用该方法，则 b 实例时浅拷贝，需要再调用 b 的克隆方法，深拷贝一份 B 示例
      clone.setB((B) b.clone());
      return clone;
    }

  }

  static class B implements Cloneable {
    private String name;

    public B(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      return super.clone();
    }
  }
}
