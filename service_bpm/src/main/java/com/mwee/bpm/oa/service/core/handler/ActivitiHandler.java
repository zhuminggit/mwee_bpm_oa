package com.mwee.bpm.oa.service.core.handler;

import com.mvee.bpm.oa.comon.entity.AbstractRestfulHandler;
import com.mvee.bpm.oa.comon.entity.Request;
import com.mvee.bpm.oa.comon.entity.RestfulResponse;
import com.mwee.bpm.oa.service.core.vo.ActivitiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chen.nie on 16/8/23.
 */
@Component
public class ActivitiHandler extends AbstractRestfulHandler {

    @Autowired
    private CacheHandler cacheHandler;


    @Override
    public RestfulResponse<?> toRestfulResponse(Request request) {
        RestfulResponse<String> response = new RestfulResponse<>();
        if (request instanceof ActivitiRequest) {
            ActivitiRequest activitiRequest = (ActivitiRequest) request;
            String str = cacheHandler.getString(activitiRequest);
            response.setData(str);
            response.setMsg("请求成功");
        }

        return response;
    }
}
