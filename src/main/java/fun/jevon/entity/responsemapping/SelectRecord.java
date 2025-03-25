package fun.jevon.entity.responsemapping;

import lombok.Data;

// 查询记录条件映射实体类
@Data
public class SelectRecord {
    private String uid;
    private Integer month;
    private Integer year;
}
