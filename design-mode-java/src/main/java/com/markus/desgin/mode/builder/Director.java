package com.markus.desgin.mode.builder;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/7
 * @Description:
 */
public interface Director<T> {
  T construct();
}
