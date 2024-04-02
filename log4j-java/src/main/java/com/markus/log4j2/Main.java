package com.markus.log4j2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;

/**
 * @author: markus
 * @date: 2024/4/1 11:51 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class Main {

    static final Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        log.info("Start process...");
        try {
            "".getBytes("invalidCharsetName");
        } catch (UnsupportedEncodingException e) {
            log.error("Invalid encoding.", e);
        }
        log.info("Process end.");
    }
}
