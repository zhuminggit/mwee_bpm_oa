package com.mwee.bpm.oa.service.common.handler;

import com.mvee.bpm.oa.comon.consts.ServiceConst;
import com.mvee.bpm.oa.comon.entity.AbstractRestfulHandler;
import com.mvee.bpm.oa.comon.entity.Request;
import com.mvee.bpm.oa.comon.entity.RestfulResponse;
import org.springframework.stereotype.Component;

/**
 * Created by chen.nie on 16/8/17.
 */
@Component("pingHandler")
public class PingHandler extends AbstractRestfulHandler {

    public String doHandler() {
        String data = String.format("Common-Service is Running ...");
        return data;
    }


    @Override
    public RestfulResponse toRestfulResponse(Request request) {
        RestfulResponse<String> response = new RestfulResponse<>();
        response.setData(this.doHandler());
        response.setMsg(ServiceConst.DescribeValue.SUC_REQUEST);
        response.setStatus(ServiceConst.ByteValue.SUCCESS);
        return response;
    }
}
