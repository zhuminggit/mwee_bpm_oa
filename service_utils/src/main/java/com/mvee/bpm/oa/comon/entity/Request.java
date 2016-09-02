package com.mvee.bpm.oa.comon.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by chen.nie on 16/8/17.
 */
@Data
@EqualsAndHashCode
public abstract class Request {
    private String sign;
    private long timestamp;
    private String version;
    private String module;
    private String service;

}
