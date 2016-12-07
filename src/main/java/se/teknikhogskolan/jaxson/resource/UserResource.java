package se.teknikhogskolan.jaxson.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import se.teknikhogskolan.jaxson.model.UserModel;

import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserResource {

    @POST
    Response createUser(UserModel user);

    @GET
    @Path("{userNumber}")
    UserModel getUserByUserNumber(@PathParam("userNumber") Long userNumber);

    @PUT
    @Path("{userNumber}")
    UserModel updateUser(@PathParam("userNumber") Long userNumber, UserModel user);

    @GET
    List<UserModel> getUserByParameter(@QueryParam("username") String username, @QueryParam("firstname") String firstname,
                                       @QueryParam("lastname") String lastname);

    /* TODO
    *  Activate and inactive user
    *  Get all by page
    *  Get all by creationDate
    * */
}
