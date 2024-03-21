package com.markus.desgin.mode.behaviour.command;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/21
 * @Description:
 */
public class CommandPattern {
  public static void main(String[] args) {
    FakeJdbcTemplate jdbcTemplate = new FakeJdbcTemplate();
    String markuszhang = jdbcTemplate.execute("markuszhang", new QueryCallback<>());
    System.out.println(markuszhang);
  }
}
