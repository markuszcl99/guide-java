package com.markus.desgin.mode.behaviour.command;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/21
 * @Description:
 */
public class FakeJdbcTemplate implements Operation {
  @Override
  public <T> T execute(String sql, Callback<T> callback) {
    Statement statement = new DefaultStatement(sql);
    return callback.doExecute(statement);
  }
}
