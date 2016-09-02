package com.mwee.bpm.oa.service.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by chen.nie on 16/8/22.
 */
@Path("/oa/bpm")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
public interface BpmService {
}
