package com.mwee.bpm.oa.service.core.run;

import com.mwee.bpm.oa.service.core.impl.BpmServiceImpl;
import com.mwee.bpm.oa.service.core.vo.ActivitiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Created by chen.nie on 16/8/22.
 */
public class BpmServiceProvider {

    public static ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");

    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static Logger LOGGER = LoggerFactory.getLogger(BpmServiceProvider.class);

    public static void main(String[] args) throws InterruptedException {
        BpmServiceImpl activityService = ctx.getBean(BpmServiceImpl.class);
       // String rst = JSON.toJSONString(ImmutableMap.of("id", 10, "age", 30));
        ActivitiRequest request = new ActivitiRequest();
        request.setKey("cache:util:snId:10000051");
        request.setUser("kermit");
        String resultString = activityService.getUserLeader(request).getData().toString();
        System.out.println(resultString);
        //countDownLatch.await();

    }
}
