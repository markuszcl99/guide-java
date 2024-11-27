package com.markus.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author: markus
 * @date: 2024/11/24 21:53
 * @Description: hello world
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class HelloWorld {
  private static final String PACKAGE_PATH = "aviator-java/src/main/java/com/markus/aviator/shell";
  private static final String USER_DIR = System.getProperty("user.dir");

  public static void main(String[] args) throws IOException {
    // 1. 编译 (默认不缓存编译方法)
    Expression expression = AviatorEvaluator.getInstance().compile("println('Hello,World!');");
    // 2. 执行
    expression.execute();

    // 3. 缓存编译结果
    expression = AviatorEvaluator.getInstance().compile("println('Hello,World!');", true);
    expression.execute();

    // 4. 接受一个变量列表组成的 map
    expression = AviatorEvaluator.compile("a+b*c");
    Map<String, Object> map = expression.newEnv("a", 1, "b", 2, "c", 3);
    // 错误写法，Aviator 会把数值类型转为 Long 或者 Double 类型
    // Integer executeValue = (Integer) expression.execute(map);
    Long executeValue = (Long) expression.execute(map);
    System.out.println(executeValue);

    // 5. 执行一个脚本文件
    expression = AviatorEvaluator.getInstance().compileScript(USER_DIR + File.separator + PACKAGE_PATH + File.separator + "hello.av");
    expression.execute();
  }

}
