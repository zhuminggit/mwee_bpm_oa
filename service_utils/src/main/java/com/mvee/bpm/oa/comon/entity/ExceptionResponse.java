package com.mvee.bpm.oa.comon.entity;

import lombok.Data;

/**
 * Created by chen.nie on 16/8/18.
 */
@Data
public class ExceptionResponse extends Response {
    private String errCode;
    private String errMsg;

}
