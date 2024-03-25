package com.markus.desgin.mode.behaviour.iterator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/25
 * @Description:
 */
public class NameRepository<E> implements Container<E> {

  private Object[] container;
  private int size;
  private int capacity = 16; // 写默认数值，这里不考虑扩容

  public NameRepository() {
    this.container = new Object[16];
  }

  @Override
  public void add(E e) {
    if (size > capacity) {
      // 直接不添加
      return;
    }
    container[size++] = e;
  }

  @Override
  public Iterator<E> iterator() {
    return new NameIterator();
  }

  private class NameIterator implements Iterator<E> {

    private int cursor;

    @Override
    public boolean hasNext() {
      return size != cursor;
    }

    @Override
    public E next() {
      // 这里不考虑并发和一些安全性问题
      return (E) container[cursor++];
    }
  }
}
