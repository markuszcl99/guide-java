package com.markus.log.jul;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.*;

/**
 * @author: markus
 * @date: 2024/5/1 8:49 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class LogTest {


    @Test
    public void testJulDefault() {
        Logger logger = Logger.getLogger(LogTest.class.getName());

        logger.info("info");
        logger.warning("warning");
        logger.severe("severe");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void testJulLogConfig() throws IOException {
        Logger logger = Logger.getLogger(LogTest.class.getName());

        // 关闭默认配置
        logger.setUseParentHandlers(false);
        // 设置日志级别
        logger.setLevel(Level.ALL);

        // 设置控制台的 Handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // handler 设置日志级别
        consoleHandler.setLevel(Level.ALL);
        // 绑定 handler
        logger.addHandler(consoleHandler);

        // 创建文件的 Handler
        FileHandler fileHandler = new FileHandler("/Users/zhangchenglong/workspace/idea_project/guide-java/log4j-java/log/log.txt");
        logger.addHandler(fileHandler);

        // 重新写日志
        logger.info("info");
        logger.warning("warning");
        logger.severe("severe");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void testJulParentRelation() {
        Logger logger1 = Logger.getLogger("com.markus.log.jul");
        Logger logger2 = Logger.getLogger("com.markus.log.jul.LogTest");

        System.out.println("logger.getParent() == parentLogger : " + (logger2.getParent() == logger1));
        System.out.println("--------------------");

        System.out.println("logger1 名称: " + logger1.getName());
        System.out.println("logger1.parent 名称: " + logger1.getParent().getName());

        System.out.println("logger2 名称: " + logger2.getName());
        System.out.println("logger2.parent 名称: " + logger2.getParent().getName());

        // 父亲所做的设置，儿子也生效
        logger1.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        logger1.addHandler(handler);
        handler.setLevel(Level.ALL);
        logger1.setLevel(Level.ALL);

        //儿子做打印
        logger2.severe("severe：错误信息");
        logger2.warning("warning：警告信息");
        logger2.info("info：默认信息");
        logger2.config("config：配置信息");
        logger2.fine("fine：详细信息(少)");
        logger2.finer("finer：详细信息(中)");
        logger2.finest("finest：详细信息(多)");
    }


}
