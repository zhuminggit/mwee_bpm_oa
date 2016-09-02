package com.mwee.bpm.oa.service.common.handler;

import com.google.common.base.Strings;
import com.mvee.bpm.oa.comon.consts.ServiceConst;
import com.mvee.bpm.oa.comon.entity.AbstractHandler;
import com.mvee.bpm.oa.comon.entity.RestfulResponse;
import org.apache.commons.io.FileUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by chen.nie on 16/8/18.
 */
@Component("uploadHandler")
public class UploadHandler extends AbstractHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(UploadHandler.class);

    //TODO:先用绝对路径
    private static final String absolutePath = "/Users/Rex/Downloads/";

    public String upload(MultipartFormDataInput input) {
        Map<String, List<InputPart>> formDataMap = input.getFormDataMap();
        StringBuilder fileNames = new StringBuilder();
        try {
            for (Map.Entry<String, List<InputPart>> entry : formDataMap.entrySet()) {
                for (InputPart inputPart : entry.getValue()) {
                    String fileName = getFileName(inputPart.getHeaders());
                    if (!Strings.isNullOrEmpty(fileName)) {
                        LOGGER.debug("upload fileName is [{}]", fileName);
                        fileNames.append(fileName).append(" ");
                        InputStream inputStream = inputPart.getBody(InputStream.class, null);

                        File file = new File(absolutePath + "/" + fileName);
                        FileUtils.copyInputStreamToFile(inputStream, file);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("上传文件出现异常", e);
            return "上传文件出现异常";
        }
        return String.format("[%s]上传文件成功", fileNames.toString());
    }

    public RestfulResponse toRestfulResponse(MultipartFormDataInput input) {
        RestfulResponse<String> response = new RestfulResponse<>();
        response.setData(this.upload(input));
        response.setMsg(ServiceConst.DescribeValue.SUC_REQUEST);
        response.setStatus(ServiceConst.ByteValue.SUCCESS);
        return response;
    }


}
