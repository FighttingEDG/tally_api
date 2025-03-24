package fun.jevon.controller;

import fun.jevon.entity.tablemapping.UserTable;
import fun.jevon.service.UserService;
import fun.jevon.util.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tally")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("getUser/{uid}")
    public Response getRecord(@PathVariable("uid") String uid){
        try {
            UserTable user = userService.getUser(uid);
            return Response.succes(user);
        }catch (Exception e){
            return Response.error(500,"无此用户");
        }
    }
}
