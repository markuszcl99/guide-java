package com.markus.basic.exception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/15
 * @Description: 主线程捕获不到子线程的异常调用栈示例以及解决方案
 */
public class ExceptionInvokeStack {
  public static void main(String[] args) {
//    question();
//    solution1();
    solution2();
  }

  private static void question() {
    // 控制台打印的实际上是 异常在子线程中抛出的，并非主线程捕获到的
    Thread t1 = new Thread(() -> {
      throw new RuntimeException("子线程异常");
    });
    try {
      t1.start();
    } catch (Exception e) {
      System.err.println("主线程捕获到了子线程异常信息" + e.getMessage());
    }
  }

  /**
   * 在Java中，当一个异常没有被捕获并且它导致了线程终止时，JVM会调用线程的UncaughtExceptionHandler的uncaughtException方法。
   * <p>
   * UncaughtExceptionHandler是一个接口，它只有一个方法uncaughtException(Thread t, Throwable e)，这个方法接受两个参数：发生异常的线程和异常对象。
   * <p>
   * 当你为一个线程设置一个UncaughtExceptionHandler时，你告诉JVM当这个线程由于未捕获的异常而终止时，应该调用你提供的处理器的uncaughtException方法。
   * <p>
   * 这样你就可以在这个方法中处理异常，比如记录日志或者通知用户。
   * <p>
   * uncaughtException 是由子线程调用的
   */
  private static void solution1() {
    Thread t1 = new Thread(() -> {
      throw new RuntimeException("子线程异常");
    });
    t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
      @Override
      public void uncaughtException(Thread t, Throwable e) {
        // 子线程中处理的
        String currentThread = Thread.currentThread().getName();
        System.out.println(currentThread + " catch exception [" + t.getName() + ": " + e.getMessage() + " ]");
      }
    });
    t1.start();
  }

  /**
   * 当你使用ExecutorService的submit方法提交一个任务（Runnable或Callable）时，ExecutorService会在一个新的线程中执行这个任务。这个新的线程是由ExecutorService的线程池提供的。
   * <p>
   * 如果任务在执行过程中抛出了一个未捕获的异常，ExecutorService不会让这个异常导致整个线程终止，而是会捕获这个异常，并将它保存下来。这是因为ExecutorService的设计目标是让线程池中的线程可以被重复使用，而不是让它们因为一个任务的异常而终止。
   * <p>
   * 当你调用Future.get方法时，如果任务已经完成，并且在执行过程中没有抛出异常，get方法会返回任务的结果。但是，如果任务在执行过程中抛出了一个未捕获的异常，get方法不会返回结果，而是会抛出一个ExecutionException。ExecutionException是一个包装异常，它的cause是任务抛出的原始异常。你可以通过ExecutionException.getCause方法获取到这个原始异常。
   * <p>
   * 所以，虽然ExecutorService在运行任务时捕获了所有的异常，但是这些异常并没有被忽略或者丢失，而是被保存到了Future对象中。你可以在任务完成后，通过Future.get方法获取到这些异常。
   * <p>
   * <br/>
   * <strong>保存异常的细节:</strong>
   * <p>
   * 当你使用ExecutorService的submit方法提交一个任务，这个任务会被包装成一个FutureTask对象。FutureTask是RunnableFuture接口的一个实现，它同时实现了Runnable和Future接口，因此它既可以作为一个任务被执行，又可以返回任务的结果或者异常。
   * <p>
   * 当ExecutorService在一个新的线程中执行这个FutureTask时，它实际上是调用了FutureTask的run方法。在run方法中，FutureTask会调用任务的call方法（如果任务是Callable的话）或者run方法（如果任务是Runnable的话），并捕获任何抛出的异常。
   * <p>
   * 如果任务正常完成，FutureTask会保存任务的结果；如果任务抛出了一个异常，FutureTask会保存这个异常。这个结果或者异常会被保存在FutureTask的一个私有字段中。
   * <p>
   * 当你调用Future.get方法时，你实际上是调用了FutureTask.get方法。在get方法中，FutureTask会检查这个私有字段。如果这个字段包含一个结果，get方法就返回这个结果；如果这个字段包含一个异常，get方法就抛出一个ExecutionException，并将这个异常设置为ExecutionException的cause。
   * <p>
   * 所以，当我们说ExecutorService会"保存"异常，我们实际上是指ExecutorService提交的任务（实际上是FutureTask）会捕获并保存异常。这样，即使任务在一个不同的线程中执行，你仍然可以在主线程中通过Future.get方法获取到任务的异常。
   */
  private static void solution2() {
    ExecutorService pool = Executors.newFixedThreadPool(1);
    Future<?> future = pool.submit(() -> {
      throw new RuntimeException("子线程异常");
    });
    try {
      Object object = future.get();
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("主线程处理了异常!");
      // 异常被 ExecutionException 包了一层
      System.out.printf("异常: %s\n", e);
      System.out.printf("原始异常: %s", e.getCause());
    }
    pool.shutdown();
  }


}
