package fun.jevon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.jevon.entity.tablemapping.UserTable;
import fun.jevon.mapper.UserMapper;
import fun.jevon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserTable> implements UserService {
    // service直接返回业务数据
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserTable getUser(String uid) {
        UserTable userTable = userMapper.getUser(uid);
        return userTable;
    }

    // 查询用户数量
    @Override
    public int getUserCount(String uid) {
        int num = userMapper.getUserCount(uid);
        return num;
    }
    // 插入用户
    @Override
    public int insertUser(UserTable userTable) {
        int num = userMapper.insertUser(userTable);
        return num;
    }
    // 修改用户
    @Override
    public int putUser(UserTable userTable) {
        int num = userMapper.putUser(userTable);
        return num;
    }
}
