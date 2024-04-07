package com.markus.desgin.mode.behaviour.chain;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/4/7
 * @Description: 责任链模式
 */
public class ChainOfResponsibility {
  public static void main(String[] args) {
    AbstractLogger logger = LoggerFactory.getLogger();
    logger.logMessage(AbstractLogger.DEBUG,"等级为 DEBUG 的日志信息");
    logger.logMessage(AbstractLogger.INFO,"等级为 INFO 的日志信息");
    logger.logMessage(AbstractLogger.WARN,"等级为 WARN 的日志信息");
    logger.logMessage(AbstractLogger.ERROR,"等级为 ERROR 的日志信息");


  }

}
