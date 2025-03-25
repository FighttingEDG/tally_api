package fun.jevon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.jevon.entity.responsemapping.RecordResponse;
import fun.jevon.entity.responsemapping.SelectRecord;
import fun.jevon.entity.tablemapping.RecordTable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecordService extends IService<RecordTable> {
    List<RecordResponse> getRecord(SelectRecord selectRecord);
}
