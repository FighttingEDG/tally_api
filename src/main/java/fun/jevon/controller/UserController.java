package fun.jevon.controller;

import fun.jevon.entity.tablemapping.UserTable;
import fun.jevon.mapper.UserMapper;
import fun.jevon.service.UserService;
import fun.jevon.util.response.Response;
import fun.jevon.util.LogUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tally")
public class UserController {
    private static final Logger logger = LogUtil.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("getUser/{uid}")
    public Response getUser(@PathVariable("uid") String uid) {
        LogUtil.logMethodEntry(logger, "getUser", uid);
        try {
            UserTable user = userService.getUser(uid);
            if (user == null) {
                logger.warn("User not found with uid: {}", uid);
                return Response.error(404, "用户不存在");
            }
            logger.info("Successfully retrieved user with uid: {}", uid);
            return Response.succes(user);
        } catch (Exception e) {
            LogUtil.logError(logger, "Error getting user with uid: " + uid, e);
            return Response.error(500, "获取用户信息失败");
        } finally {
            LogUtil.logMethodExit(logger, "getUser", null);
        }
    }

    // 查询用户是否存在
    @GetMapping("getUserCount/{uid}")
    public Response getUserCount(@PathVariable("uid") String uid) {
        LogUtil.logMethodEntry(logger, "getUserCount", uid);
        try {
            int count = userService.getUserCount(uid);
            if (count > 0 && count == 1) {
                logger.info("User exists with uid: {}", uid);
                return Response.succes("查询成功，用户存在");
            }
            logger.warn("User not found with uid: {}", uid);
            return Response.error(404, "用户不存在");
        } catch (Exception e) {
            LogUtil.logError(logger, "Error checking user count with uid: " + uid, e);
            return Response.error(500, "查询用户失败");
        } finally {
            LogUtil.logMethodExit(logger, "getUserCount", null);
        }
    }

    // 插入用户
    @PostMapping("insertUser")
    public Response insertUser(@RequestBody UserTable userTable) {
        LogUtil.logMethodEntry(logger, "insertUser", userTable);
        try {
            int num = userMapper.getUserCount(userTable.getUid());
            if (num > 0) {
                logger.warn("User already exists with uid: {}", userTable.getUid());
                return Response.error(409, "用户已存在");
            }
            userService.insertUser(userTable);
            LogUtil.logBusinessOperation(logger, "User Insert", userTable.getUid(), "New user created successfully");
            logger.info("Successfully inserted user with uid: {}", userTable.getUid());
            return Response.succes("插入成功");
        } catch (Exception e) {
            LogUtil.logError(logger, "Error inserting user with uid: " + userTable.getUid(), e);
            return Response.error(500, "插入用户失败");
        } finally {
            LogUtil.logMethodExit(logger, "insertUser", null);
        }
    }

    // 修改用户
    @PutMapping("putUser")
    public Response putUser(@RequestBody UserTable userTable) {
        LogUtil.logMethodEntry(logger, "putUser", userTable);
        try {
            int num = userMapper.putUser(userTable);
            // 只可能有一条满足
            if(num == 1){
                UserTable userTable1 = userService.getUser(userTable.getUid());
                LogUtil.logBusinessOperation(logger, "User Update", userTable.getUid(), "User updated successfully");
                logger.info("Successfully updated user with uid: {}", userTable.getUid());
                return Response.succes(userTable1);
            }
            logger.warn("User not found for update with uid: {}", userTable.getUid());
            return Response.error(404,"用户不存在");
        } catch (Exception e) {
            LogUtil.logError(logger, "Error updating user with uid: " + userTable.getUid(), e);
            return Response.error(500, "更新用户失败");
        } finally {
            LogUtil.logMethodExit(logger, "putUser", null);
        }
    }
}
