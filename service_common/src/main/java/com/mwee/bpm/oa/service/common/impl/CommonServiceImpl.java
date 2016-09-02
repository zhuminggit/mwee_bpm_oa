package com.mwee.bpm.oa.service.common.impl;

import com.mvee.bpm.oa.comon.entity.Response;
import com.mwee.bpm.oa.service.api.CommonService;
import com.mwee.bpm.oa.service.common.handler.UploadHandler;
import com.mwee.bpm.oa.service.common.handler.PingHandler;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by chen.nie on 16/8/18.
 */
@Component("commonService")
public class CommonServiceImpl implements CommonService {

    @Resource
    private UploadHandler handler;

    @Resource
    private PingHandler pingHandler;

    @Override
    public Response upload(MultipartFormDataInput input) {
        return handler.toRestfulResponse(input);
    }

    @Override
    public Response ping() {
        return pingHandler.toRestfulResponse(null);
    }
}
