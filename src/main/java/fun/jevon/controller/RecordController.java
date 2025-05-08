package fun.jevon.controller;

import fun.jevon.entity.responsemapping.RecordResponse;
import fun.jevon.entity.responsemapping.SelectRecord;
import fun.jevon.service.RecordService;
import fun.jevon.util.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tally")
public class RecordController {
    @Autowired
    private RecordService recordService;
    @PostMapping("getRecord")
    public Response getRecord(@RequestBody SelectRecord selectRecord){
        try {
            List<RecordResponse> recordList = recordService.getRecord(selectRecord);
            return Response.succes(recordList);
        }catch (Exception e){
            return Response.error(500,"获取记录失败");
        }
    }
}
