package spring.webService.service;

import spring.webService.bean.User;

import javax.ws.rs.*;
import java.util.List;

/**
 * @Author: 李昭
 * @Date: 2020/3/9 19:32
 */
@Produces("*/*")
public interface UserService {
    @POST
    @Path("/user")
    @Consumes({"application/xml", "application/json"})
    public void saveUser(User user);

    @PUT
    @Path("/user")
    @Consumes({"application/xml", "application/json"})
    public void updateUser(User user);

    @GET
    @Path("/user")
    @Produces({"application/xml", "application/json"})
    public List<User> findAllUsers();

    @GET
    @Path("/user/{id}")
    @Consumes("application/xml")
    @Produces({"application/xml", "application/json"})
    public User finUserById(@PathParam("id") Integer id);

    @DELETE
    @Path("/user/{id}")
    @Consumes({"application/xml", "application/json"})
    public void deleteUser(@PathParam("id") Integer id);
}
