package com.mwee.bpm.oa.service.common.vo;

import com.mvee.bpm.oa.comon.entity.Request;
import lombok.Data;

/**
 * Created by chen.nie on 16/8/17.
 */
@Data
public class HelloRequest extends Request{
    private String name;
    private int age;
}
