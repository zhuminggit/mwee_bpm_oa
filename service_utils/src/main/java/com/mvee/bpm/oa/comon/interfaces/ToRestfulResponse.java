package com.mvee.bpm.oa.comon.interfaces;

import com.mvee.bpm.oa.comon.entity.Request;
import com.mvee.bpm.oa.comon.entity.RestfulResponse;

/**
 * Created by chen.nie on 16/8/17.
 */
public interface ToRestfulResponse {

     RestfulResponse<?> toRestfulResponse(Request request);
}
