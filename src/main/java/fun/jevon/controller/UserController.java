package fun.jevon.controller;

import fun.jevon.entity.tablemapping.UserTable;
import fun.jevon.mapper.UserMapper;
import fun.jevon.service.UserService;
import fun.jevon.util.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tally")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("getUser/{uid}")
    public Response getUser(@PathVariable("uid") String uid) {
        UserTable user = userService.getUser(uid);
        if (user == null) {
            return Response.error(404, "用户不存在");
        }
        return Response.succes(user);
    }

    // 查询用户是否存在
    @GetMapping("getUserCount/{uid}")
    public Response getUserCount(@PathVariable("uid") String uid) {
        int count = userService.getUserCount(uid);
        if (count > 0 && count == 1) {
            return Response.succes("查询成功，用户存在");
        }
        return Response.error(404, "用户不存在");
    }

    // 插入用户
    @PostMapping("insertUser")
    public Response insertUser(@RequestBody UserTable userTable) {
        int num = userMapper.getUserCount(userTable.getUid());
        if (num > 0) {
            return Response.error(409, "用户已存在");
        }
        userService.insertUser(userTable);
        return Response.succes("插入成功");
    }
}
