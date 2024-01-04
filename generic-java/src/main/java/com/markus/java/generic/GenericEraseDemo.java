package com.markus.java.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * @author: markus
 * @date: 2023/12/30 10:09 PM
 * @Description: 泛型擦除 示例
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class GenericEraseDemo {
    public static void main(String[] args) {
        List<Number> elements = new CustomizedCollection<>();

        elements.add(1);
        elements.add(2.0d);
        elements.add(3.0f);

        Collection temp = elements;
        temp.add("hello");

        System.out.println(elements);

        Type genericSuperClass = elements.getClass().getGenericSuperclass();

        Class<Number> typeParameterClass = null;
        if (genericSuperClass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperClass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length > 0 && actualTypeArguments[0] instanceof Class) {
                typeParameterClass = (Class<Number>) actualTypeArguments[0];
            }
        }

        if (typeParameterClass != null && Number.class.isAssignableFrom(typeParameterClass)) {
            System.out.println("Type parameter is a subclass of Number");
        } else {
            System.out.println("Type parameter is not a subclass of Number");
        }
    }
}
