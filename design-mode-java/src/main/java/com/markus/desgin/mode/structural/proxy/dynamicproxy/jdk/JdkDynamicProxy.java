package com.markus.desgin.mode.structural.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/20
 * @Description:
 */
public class JdkDynamicProxy {
  public static void main(String[] args) {
    // 将生成的字节码文件保存到本地 sun.misc.ProxyGenerator.generateProxyClass(java.lang.String, java.lang.Class<?>[], int)
    System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    EchoService echoService = new DefaultEchoService();
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    EchoService proxyEchoService = (EchoService) Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Jdk Dynamic Proxy...");
        System.out.println("invoke target method before");
        Object retVal = method.invoke(echoService, args);
        System.out.println("target method return value : " + retVal);
        System.out.println("invoke target method after");
        return retVal;
      }
    });
    proxyEchoService.echo("Hello,Jdk Dynamic Proxy!");
  }
}
