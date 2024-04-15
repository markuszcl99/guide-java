package com.markus.basic.collecton.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/13
 * @Description:
 */
public class LinkedHashSetCase {
  public static void main(String[] args) {
    Set<DebugModule> set = new HashSet<>();
    DebugModule module1 = new DebugModule();
    module1.setModule("AAA");
    module1.setAppkey("com.markus.basic.collection.set");
    set.add(module1);

    DebugModule module2 = new DebugModule();
    module2.setModule("BBB");
    module2.setAppkey("com.markus.basic.collection.set");
    set.add(module2);

    System.out.println(set);

  }

  static class DebugModule {
    String appkey;
    String module;


    public String getAppkey() {
      return appkey;
    }

    public void setAppkey(String appkey) {
      this.appkey = appkey;
    }

    public String getModule() {
      return module;
    }

    public void setModule(String module) {
      this.module = module;
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) return true;
      if (object == null || getClass() != object.getClass()) return false;
      DebugModule that = (DebugModule) object;
      return Objects.equals(appkey, that.appkey);
    }

    @Override
    public int hashCode() {
      return Objects.hash(appkey);
    }
  }
}
