package com.markus.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.Map;

/**
 * @author: markus
 * @date: 2024/11/24 21:53
 * @Description: hello world
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class HelloWorld {
    public static void main(String[] args) {
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
    }

}
