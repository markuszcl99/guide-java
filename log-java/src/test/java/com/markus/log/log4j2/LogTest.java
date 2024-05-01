package com.markus.log.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: markus
 * @date: 2024/5/1 11:16 PM
 * @Description: log4j2 日志打印
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class LogTest {

    public static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void quickStart() {
        //打印日志信息
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug"); // 默认级别
        logger.trace("trace");
    }
}
