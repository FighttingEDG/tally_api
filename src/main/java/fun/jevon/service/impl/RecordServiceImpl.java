package fun.jevon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.jevon.entity.responsemapping.RecordResponse;
import fun.jevon.entity.tablemapping.RecordTable;
import fun.jevon.mapper.RecordMapper;
import fun.jevon.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, RecordTable> implements RecordService {
    // service直接返回业务数据
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public List<RecordResponse> getRecord(String id) {
        List<RecordResponse> recordList = recordMapper.getRecord(id);
        return recordList;
    }
}
