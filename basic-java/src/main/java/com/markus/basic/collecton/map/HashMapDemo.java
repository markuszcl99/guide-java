package com.markus.basic.collecton.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/10
 * @Description:
 */
public class HashMapDemo {
  public static void main(String[] args) {
    Map<String,String> map1 = new HashMap<>();
    map1.put("1","1");

    Map<String,String> map2 = new HashMap<>();
    map2.put("1","1");

    System.out.println(map1.equals(map2));
  }
}
