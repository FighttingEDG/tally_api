package fun.jevon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.jevon.entity.tablemapping.UserTable;
import org.springframework.stereotype.Service;


@Service
public interface UserService extends IService<UserTable> {
    // 根据uid查用户，只能有一条记录
    UserTable getUser(String uid);
    // 查询用户数量
    int getUserCount(String uid);
    // 插入用户
    int insertUser(UserTable userTable);
    // 修改用户
    int putUser(UserTable userTable);
}
