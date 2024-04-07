package com.markus.desgin.mode.behaviour.chain;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/7
 * @Description:
 */
public abstract class AbstractLogger {
  public static final int DEBUG = 1;
  public static final int INFO = 2;
  public static final int WARN = 3;
  public static final int ERROR = 4;

  private final int level;

  /**
   * 下一个级别的日志 logger
   */
  private AbstractLogger nextLogger;

  public AbstractLogger(int level) {
    this.level = level;
  }

  public void setNextLogger(AbstractLogger abstractLogger) {
    this.nextLogger = abstractLogger;
  }

  public final void logMessage(int level, String message) {
    if (this.level <= level) {
      write(message);
    }
    if (this.nextLogger != null) {
      this.nextLogger.logMessage(level, message);
    }
  }

  protected abstract void write(String message);

}
