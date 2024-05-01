package com.markus.log.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author: markus
 * @date: 2024/5/1 9:26 PM
 * @Description: log4j 的日志打印
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class LogTest {

    /**
     * 日志入门资料: https://blog.csdn.net/zyb18507175502/article/details/131617841
     * <p>
     * Log4j 的主要组件：
     * <p> 1. Logger : 控制日志的输出级别和日志是否输出
     * <p> 2. Appender : 控制日志的输出方式（控制台、文件、网络等）
     * <p> 3. Layout : 控制日志的输出格式
     * <p>
     *
     */

    @Test
    public void testLog4jQuickStart() {
        // 初始化系统配置 不需要配置文件
        BasicConfigurator.configure();
        // 创建日志记录器对象
        Logger logger = Logger.getLogger(LogTest.class);
        logger.trace("trace"); // 追踪信息，记录程序的所有流程信息
        logger.debug("debug"); // 调试信息，一般在开发阶段使用，记录程序的变量、参数等
        logger.info("info");   // 程序运行信息，数据库的连接、网络、IO 操作等
        logger.warn("warn");   // 警告信息，可能会发生问题
        logger.error("error"); // 错误信息，但不会影响系统运行
        logger.fatal("fatal"); // 严重错误，一般会造成系统崩溃和终止运行
    }

}
