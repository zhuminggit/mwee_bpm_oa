package com.mwee.bpm.oa.service.core.handler;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mwee.bpm.oa.dao.entity.ActUserEntity;
import com.mwee.bpm.oa.dao.mapper.ActUserEntityMapper;
import com.mwee.bpm.oa.service.core.vo.ActivitiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by chen.nie on 16/8/23.
 */
@Component
public class CacheHandler {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ActUserEntityMapper actUserEntityMapper;

    @Cacheable(key = "#request.getKey()", value = "db0")
    public String getString(ActivitiRequest request) {
        PageHelper.startPage(1,2);
        Page<ActUserEntity> page = actUserEntityMapper.selectAll();
        LOGGER.info("page total is {}",page.getTotal());
        return page == null ? "" : page.get(0).getFirst().concat(page.get(0).getLast());
    }
}
