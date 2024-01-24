package ru.aaaTurbo.rest;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.aaaTurbo.beans.HitChecker;
import ru.aaaTurbo.beans.Input;
import ru.aaaTurbo.beans.ResultBean;
import ru.aaaTurbo.beans.ResultManager;
import ru.aaaTurbo.jpa.ResultEntity;

import java.util.List;

@Path("/")
public class CheckResource {

    @EJB
    HitChecker hitChecker;

    @EJB
    ResultManager results;


    @POST
    @Path("/check")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response check(Input input, @CookieParam("name") String username) {
        if (!username.equals("")) {
            input.setUsername(username);
            ResultBean res = new ResultBean(input.getX(), input.getY(), input.getR(), false);
            res.setResult(hitChecker.check(input));
            return Response.ok().entity(res).build();
        }
        return Response.status(401).build();
    }

    @GET
    @Path("/results")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResults(@CookieParam("name") String username) {
        Response.ResponseBuilder res;
        if (username != null) {
            if (!username.equals("")) {
                List<ResultBean> list = results.getResults(username);
                res = Response.ok();
                if (list != null) {
                    return res.entity(list).build();
                } else {
                    return res.entity(true).build();
                }
            }
        }
        res = Response.status(400);
        return res.build();
    }

    @GET
    @Path("/clear")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearResults(@CookieParam("name") String username) {
        if (!username.equals("")) {
            results.clear(username);
            return Response.ok().build();
        }
        return Response.status(400).build();
    }
}
