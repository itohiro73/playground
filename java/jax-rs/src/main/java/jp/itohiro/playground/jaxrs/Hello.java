package jp.itohiro.playground.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


// http://localhost:8979/jax-rs/hello
@Path("/hello")
public class Hello {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String hello() {
        return "<b>Hello, World!</b>";
    }
}
