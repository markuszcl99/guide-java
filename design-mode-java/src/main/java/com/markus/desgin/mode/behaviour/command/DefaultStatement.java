package com.markus.desgin.mode.behaviour.command;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/21
 * @Description:
 */
public class DefaultStatement implements Statement {
  final String key;

  public DefaultStatement(String key) {
    this.key = key;
  }

  @Override
  public Result executeQuery() {
    Result result = new Result();
    result.setData(DataBase.getData(key));
    return result;
  }
}
