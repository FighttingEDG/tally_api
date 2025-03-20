package fun.jevon.config;

import fun.jevon.util.response.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Response<String> handleException(Exception e) {
        return Response.error(500, "服务器内容错误：" + e.getMessage());
    }
}
