package com.mwee.bpm.oa.service.common.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by chen.nie on 16/8/16.
 */
public class CommonServiceProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonServiceProvider.class);

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");

    public static void main(String[] args) {
        LOGGER.info("正在启动common-service服务.....");
       // System.out.println(1/0);
        try {
            ctx.start();
            System.out.println("common-service服务已经启动.....");
            countDownLatch.await();
        } catch (Exception e) {
            LOGGER.error("common-service启动失败..", e);
        }
    }
}
