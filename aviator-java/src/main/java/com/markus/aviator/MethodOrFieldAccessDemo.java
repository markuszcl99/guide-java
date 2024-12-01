package com.markus.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: markus
 * @date: 2024/12/1 11:02
 * @Description: 方法或字段访问示例
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MethodOrFieldAccessDemo {
    private static class Person {
        private String username;
        private Integer age;
        private String address;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setUsername("markus zhang");
        person.setAge(25);
        person.setAddress("山东菏泽");
        AviatorEvaluatorInstance evaluator = AviatorEvaluator.getInstance();
        Expression expression = evaluator.compile("person.username");
        Map<String, Object> env = new HashMap<>();
        env.put("person", person);
        Object execute = expression.execute(env);
        System.out.println(execute);

        // 尝试获取方法值 没有找到获取方法调用的办法
//        AviatorEvaluator.execute("use com.markus.aviator.MethodOrFieldAccessDemo.Person; getUsername(person)",env);
    }
}
