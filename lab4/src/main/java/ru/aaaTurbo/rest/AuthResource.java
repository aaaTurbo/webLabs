package ru.aaaTurbo.rest;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;
import ru.aaaTurbo.beans.Auth;
import ru.aaaTurbo.jpa.UserEntity;

@Path("/auth")
public class AuthResource {
    @EJB
    private Auth auth;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(UserEntity user) {
        if (auth.register(user)) {
            return Response.ok().build();
        }
        return Response.status(401).build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(UserEntity user) {
        System.out.println(user.toString());
        if (auth.login(user)) {
            Response.ResponseBuilder res = Response.ok();
            return res.cookie(new NewCookie("name", user.getName(), "/", "", "", 1209600, false)).build();
        }
        return Response.status(400).build();
    }

    @GET
    @Path("/logout")
    public Response logout() {
        Response.ResponseBuilder res = Response.ok();
        return res.cookie(new NewCookie("name", null,"/", "", "", 0, false)).build();
    }

    @GET
    @Path("/")
    public Response checkAuth(@CookieParam("name") String username) {
        if (username != null || !username.equals("")) {
            return Response.ok().build();
        }
        return Response.status(401).build();
    }
}
