package fun.jevon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.jevon.entity.tablemapping.UserTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserTable> {
    // 根据openid获取用户信息
    UserTable getUser(String uid);
    // 查询用户是否存在
    int getUserCount(String uid);
    // 插入用户
    int insertUser(UserTable userTable);
    // 修改用户
    int putUser(UserTable userTable);

}
