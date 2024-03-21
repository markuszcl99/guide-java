package com.markus.desgin.mode.behaviour.command;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/21
 * @Description:
 */
public class QueryCallback<T> implements Callback<T> {
  @Override
  public T doExecute(Statement statement) {
    Result result = statement.executeQuery();
    //noinspection unchecked
    return (T) result.getData();
  }
}
