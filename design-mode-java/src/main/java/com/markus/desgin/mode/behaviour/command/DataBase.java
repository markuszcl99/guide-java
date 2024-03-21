package com.markus.desgin.mode.behaviour.command;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/21
 * @Description:
 */
public class DataBase {
  private static Map<String, String> data = new ConcurrentHashMap<>();

  static {
    data.put("markuszhang", "张成龙");
    data.put("luna", "徐芳");
  }

  public static String getData(String key) {
    return data.get(key);
  }
}
