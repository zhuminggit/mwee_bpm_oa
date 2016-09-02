package com.mvee.bpm.oa.comon.entity;

import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by chen.nie on 16/8/17.
 */
public abstract class AbstractHandler {


    /**
     * header sample
     * {
     * Content-Type=[image/png],
     * Content-Disposition=[form-data; name="file"; filename="filename.extension"]
     * }
     **/
    //get uploaded filename, is there a easy way in RESTEasy?
    protected String getFileName(MultivaluedMap<String, String> header) {
        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {
                return filename.trim().replace("filename=", "").replace("\"", "");
            }
        }
        return null;
    }




}
