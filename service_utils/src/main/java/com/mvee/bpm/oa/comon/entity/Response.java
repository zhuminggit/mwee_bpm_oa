package com.mvee.bpm.oa.comon.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by chen.nie on 16/8/18.
 */
@Data
@EqualsAndHashCode
public abstract class Response {
    private int status;
    private String msg;
    private long elapsedMilliseconds;
}
