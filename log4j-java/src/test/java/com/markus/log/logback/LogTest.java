package com.markus.log.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: markus
 * @date: 2024/5/1 9:51 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class LogTest {

    public final static Logger logger = LoggerFactory.getLogger(LogTest.class);
    public final static Logger custom_logger = LoggerFactory.getLogger("my_custom_logger");

    @Test
    public void quickStart() {
        //打印日志信息
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug"); // 默认级别
        logger.trace("trace");
    }

    @Test
    public void testMoreThanOneMB() {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 1048576; i++) {
            name.append("zhangchenglong06");
        }
        logger.info("my name is " + name.toString());
    }

    @Test
    public void testLogFilter() {
        //打印日志信息
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug"); // 默认级别
        logger.trace("trace");
    }

    @Test
    public void testAsyncAppender() throws InterruptedException {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 1048576; i++) {
            name.append("zhangchenglong06");
        }
        long start = System.currentTimeMillis();
        logger.info("my name is " + name);
        long end = System.currentTimeMillis();
        logger.error("cost time : " + (end - start));

        Thread.sleep(20000);
    }

    @Test
    public void testCustomLogger(){
        //打印日志信息
        custom_logger.error("error");
        custom_logger.warn("warn");
        custom_logger.info("info");
        custom_logger.debug("debug");
        custom_logger.trace("trace");
    }
}
