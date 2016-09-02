package com.mwee.bpm.oa.service.core.impl;

import com.mvee.bpm.oa.comon.entity.RestfulResponse;
import com.mwee.bpm.oa.service.core.handler.ActivitiHandler;
import com.mwee.bpm.oa.service.core.vo.ActivitiRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by chen.nie on 16/8/22.
 */
@Component("activityService")
public class BpmServiceImpl {
    //
//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    private IdentityService identityService;
//
//
//    @Transactional(rollbackFor = Exception.class)
//    public String test() {
//        System.out.println("开始请假.....");
//        runtimeService.startProcessInstanceByKey("bpm_free_process");
//        TaskQuery taskQuery = taskService.createTaskQuery().taskAssignee("employee");
//        taskQuery.list().forEach(task -> {
//            System.out.println(task.getName());
//            taskService.complete(task.getId(), ImmutableMap.of("name", "Tellon", "day", 4, "continue", 1));
//        });
//        System.out.println("请假完毕");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("boss开始处理任务...");
//        taskQuery = taskService.createTaskQuery().taskAssignee("boss");
//        taskQuery.list().forEach(task -> {
//            System.out.println(task.getName());
//            taskService.complete(task.getId(), ImmutableMap.of("agree", new Random().nextInt(100) % 2));
//        });
//        System.out.println("boss处理结束...");
//        return null;
//    }
    @Resource
    private ActivitiHandler activitiHandler;

    public RestfulResponse getUserLeader(ActivitiRequest request) {
        return activitiHandler.toRestfulResponse(request);
    }
}
