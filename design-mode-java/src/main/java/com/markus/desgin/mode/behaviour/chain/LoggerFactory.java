package com.markus.desgin.mode.behaviour.chain;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/7
 * @Description:
 */
public class LoggerFactory {
  private static final AbstractLogger logger;

  static {
    logger = new ConsoleLogger(1);
    AbstractLogger infoFileLogger = new InfoFileLogger(2);
    WarnFileLogger warnFileLogger = new WarnFileLogger(3);
    ErrorFileLogger errorFileLogger = new ErrorFileLogger(4);

    // 设置责任链
    logger.setNextLogger(infoFileLogger);
    infoFileLogger.setNextLogger(warnFileLogger);
    warnFileLogger.setNextLogger(errorFileLogger);
  }

  public static AbstractLogger getLogger() {
    return logger;
  }
}
