package se.teknikhogskolan.resource.interfaces;

import se.teknikhogskolan.model.UserModel;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public interface UserResource {

    @POST
    UserModel createUser(UserModel user);

    @PUT
    @Path("{userNumber}")
    UserModel updateUser(@PathParam("userNumber") Long userNumber, UserModel user);

}
