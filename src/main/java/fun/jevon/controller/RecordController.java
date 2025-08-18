package fun.jevon.controller;

import fun.jevon.entity.responsemapping.RecordResponse;
import fun.jevon.entity.responsemapping.SelectRecord;
import fun.jevon.service.RecordService;
import fun.jevon.util.response.Response;
import fun.jevon.util.LogUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tally")
public class RecordController {
    private static final Logger logger = LogUtil.getLogger(RecordController.class);
    
    @Autowired
    private RecordService recordService;
    
    @PostMapping("getRecord")
    public Response getRecord(@RequestBody SelectRecord selectRecord){
        LogUtil.logMethodEntry(logger, "getRecord", selectRecord);
        try {
            List<RecordResponse> recordList = recordService.getRecord(selectRecord);
            logger.info("Successfully retrieved {} records for user: {}", 
                       recordList.size(), selectRecord.getUid());
            return Response.succes(recordList);
        } catch (Exception e) {
            LogUtil.logError(logger, "Error getting records for user: " + selectRecord.getUid(), e);
            return Response.error(500,"获取记录失败");
        } finally {
            LogUtil.logMethodExit(logger, "getRecord", null);
        }
    }
}
