package com.markus.java.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/2/20
 * @Description:
 */
public class MyClassFileTransformer implements ClassFileTransformer {

  @Override
  public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
    // 在这里可以对字节码进行修改
    // 可以使用字节码操作库（如 ASM 或 Javassist）来修改类的字节码。
    if (className != null && className.startsWith("com/markus/")) {
      System.out.println("Transforming " + className);
    }
    return classfileBuffer;
  }
}
