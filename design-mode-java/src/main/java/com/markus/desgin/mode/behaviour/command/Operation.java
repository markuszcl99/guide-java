package com.markus.desgin.mode.behaviour.command;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/21
 * @Description:
 */
public interface Operation {
  <T> T execute(String sql, Callback<T> callback);
}
