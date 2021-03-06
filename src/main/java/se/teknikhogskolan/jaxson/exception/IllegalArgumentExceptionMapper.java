package se.teknikhogskolan.jaxson.exception;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public final class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException exception) {
        return Response.status(BAD_REQUEST)
                .entity(new ErrorMessage(BAD_REQUEST.getStatusCode(), BAD_REQUEST.toString(), exception.getMessage()))
                .build();
    }
}