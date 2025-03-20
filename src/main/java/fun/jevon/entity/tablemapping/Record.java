package fun.jevon.entity.tablemapping;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("transaction_records")
public class Record {
    @TableId
    private int id;
    private String name;
    private String detail;
    private BigDecimal amount;
    private LocalDateTime time;
    private int uid;
}
