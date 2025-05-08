package fun.jevon.controller;

import fun.jevon.util.response.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/thread")
public class testThread {
    @GetMapping("test")
    public Response testThread() {
        try {
            return Response.succes("线程池");
        } catch (Exception e) {
            return Response.error(500, "服务器错误");
        }
    }
}
