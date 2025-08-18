package fun.jevon.config;

import fun.jevon.util.response.Response;
import fun.jevon.util.LogUtil;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类，用于处理应用中的异常。
 * 该类会捕捉所有 Controller 层的异常，并返回统一格式的错误响应。
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger logger = LogUtil.getLogger(GlobalExceptionHandler.class);

    /**
     * 异常处理方法，用于捕捉所有类型的异常。
     * @param e 捕获到的异常
     * @return 返回统一格式的错误响应，包含错误代码和错误信息
     */
    @ExceptionHandler(Exception.class)
    public Response<String> handleException(Exception e) {
        // 记录异常日志
        LogUtil.logError(logger, "Global exception caught", e);
        logger.error("Exception details - Class: {}, Message: {}, Stack trace: {}", 
                   e.getClass().getSimpleName(), e.getMessage(), e.getStackTrace());
        
        // 创建并返回一个错误响应对象，状态码为 500，错误消息为服务器内容错误，并附加异常信息
        return Response.error(500, "服务器内容错误：" + e.getMessage());
    }
}
