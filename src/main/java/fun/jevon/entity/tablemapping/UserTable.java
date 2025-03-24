package fun.jevon.entity.tablemapping;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class UserTable {
    @TableId
    private int id;
    private String nickName;
    private int monthlyIncome;
    private String uid;
}
