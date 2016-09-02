package com.mvee.bpm.oa.comon.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by chen.nie on 16/8/17.
 */
@Data
@EqualsAndHashCode
public class RestfulResponse<T extends Serializable> extends Response{
    private T data;
}
