package com.mvee.bpm.oa.comon.aspect;

import com.google.common.base.Stopwatch;
import com.mvee.bpm.oa.comon.consts.ServiceConst;
import com.mvee.bpm.oa.comon.entity.ExceptionResponse;
import com.mvee.bpm.oa.comon.entity.RestfulResponse;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by chen.nie on 16/8/18.
 */

public class ServiceAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);

    /**
     * 记录service执行时间并统一错误处理
     * @param point
     * @return
     */
    public Object consumingTimes(ProceedingJoinPoint point) {

        String method = point.getSignature().getName();
        String target = point.getTarget().getClass().getName();
        Object[] args = point.getArgs();
        try {
            LOGGER.info(String.format("执行[%s]的方法[%s]", target, method));
            Stopwatch stopwatch = Stopwatch.createStarted();
            Object object = point.proceed(args);
            stopwatch.stop();
            RestfulResponse restfulResponse = (RestfulResponse) object;
            restfulResponse.setElapsedMilliseconds(stopwatch.elapsed(TimeUnit.MILLISECONDS));
            return restfulResponse;
        } catch (Throwable ex) {
            LOGGER.error(String.format("执行[%s]的方法[%s]时出现异常", target, method), ex);
            ExceptionResponse response = new ExceptionResponse();
            response.setErrCode(ServiceConst.ErrorCode.ERR_JAVA_SERVICE);
            response.setErrMsg(ExceptionUtils.getStackTrace(ex).replace("\n\t", "\n"));
            return response;
        }
    }

}
