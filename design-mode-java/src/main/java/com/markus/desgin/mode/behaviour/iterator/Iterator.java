package com.markus.desgin.mode.behaviour.iterator;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/25
 * @Description:
 */
public interface Iterator<E> {
  boolean hasNext();

  E next();
}
