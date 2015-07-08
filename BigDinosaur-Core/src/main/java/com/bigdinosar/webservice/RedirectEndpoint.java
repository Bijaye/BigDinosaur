/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdinosar.webservice;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.core.HttpResponseContext;

/**
 *
 * @author jdlee
 */
@Path("/redirect")
public class RedirectEndpoint {

    @Context
    HttpHeaders httpHeaders;
    @Context
    UriInfo uriInfo;

    @GET
    public Response redirect(@Context HttpServletRequest request,@Context HttpServletResponse response) {
        JSONObject object = new JSONObject();
        JSONObject headers = new JSONObject(); 
        JSONObject qp = new JSONObject();
        String json = "error!";
        try {
            for (Map.Entry<String, List<String>> entry : httpHeaders.getRequestHeaders().entrySet()) {
                headers.put(entry.getKey(), entry.getValue().get(0));
            }
            object.put("headers", headers);
            for (Map.Entry<String, List<String>> entry : uriInfo.getQueryParameters().entrySet()) {
                qp.put(entry.getKey(), entry.getValue().get(0));
            }
            object.put("queryParameters", qp);
            json = object.toString(4);
            System.out.println(json);
            return Response.status(200).entity(json).build();
        } catch (JSONException ex) {
            Logger.getLogger(RedirectEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return json;
		return null;
    }
}
