package fun.jevon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.jevon.entity.tablemapping.UserTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserTable> {
    UserTable getUser(String uid);
}
