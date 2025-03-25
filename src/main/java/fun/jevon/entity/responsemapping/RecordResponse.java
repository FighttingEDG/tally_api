package fun.jevon.entity.responsemapping;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
// 查询返回映射实体类
@Data
public class RecordResponse {
    private int id;
    private String name;
    private String detail;
    private BigDecimal amount;
    private LocalDateTime time;
}
