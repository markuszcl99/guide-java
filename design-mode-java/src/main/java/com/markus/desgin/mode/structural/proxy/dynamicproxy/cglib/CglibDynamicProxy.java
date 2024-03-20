package com.markus.desgin.mode.structural.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/20
 * @Description:
 */
public class CglibDynamicProxy {
  public static void main(String[] args) {
    EchoService echoService = new DefaultEchoService();
    Enhancer enhancer = new Enhancer();
    // 与 jdk 动态代理的区别：可以指定具体类而非接口
    enhancer.setSuperclass(DefaultEchoService.class);
    enhancer.setClassLoader(Thread.currentThread().getContextClassLoader());
    enhancer.setCallback(new MethodInterceptor() {
      @Override
      public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Cglib Dynamic Proxy...");
        System.out.println("invoke target method before");
        Object retVal = method.invoke(echoService, args);
        System.out.println("target method return value : " + retVal);
        System.out.println("invoke target method after");
        return retVal;
      }
    });
    EchoService proxyEchoService = (EchoService) enhancer.create();
    proxyEchoService.echo("Hello,Cglib Dynamic Proxy");
  }
}
