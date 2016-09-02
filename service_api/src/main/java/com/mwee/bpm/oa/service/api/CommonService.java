package com.mwee.bpm.oa.service.api;

import com.mvee.bpm.oa.comon.entity.Response;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by chen.nie on 16/8/22.
 */
@Path("/oa/common")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
public interface CommonService {

    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    Response upload(MultipartFormDataInput input);

    @GET
    @Path("/ping")
    Response ping();
}
