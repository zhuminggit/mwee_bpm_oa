package com.mwee.bpm.oa.service.core.vo;

import com.mvee.bpm.oa.comon.entity.Request;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by chen.nie on 16/8/23.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ActivitiRequest extends Request {
    private String key;
    private String user;
}
