package fun.jevon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import fun.jevon.entity.responsemapping.RecordResponse;
import fun.jevon.entity.responsemapping.SelectRecord;
import fun.jevon.entity.tablemapping.RecordTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper extends BaseMapper<RecordTable> {
    List<RecordResponse> getRecord(SelectRecord selectRecord);
}
