package fun.jevon.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具类
 * 提供统一的日志记录方法
 */
public class LogUtil {
    
    /**
     * 获取指定类的日志记录器
     * @param clazz 类
     * @return Logger实例
     */
    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
    
    /**
     * 获取指定名称的日志记录器
     * @param name 名称
     * @return Logger实例
     */
    public static Logger getLogger(String name) {
        return LoggerFactory.getLogger(name);
    }
    
    /**
     * 记录方法进入日志
     * @param logger 日志记录器
     * @param methodName 方法名
     * @param params 参数
     */
    public static void logMethodEntry(Logger logger, String methodName, Object... params) {
        if (logger.isDebugEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Entering method: ").append(methodName);
            if (params != null && params.length > 0) {
                sb.append(" with parameters: ");
                for (int i = 0; i < params.length; i++) {
                    if (i > 0) sb.append(", ");
                    sb.append("param").append(i + 1).append("=").append(params[i]);
                }
            }
            logger.debug(sb.toString());
        }
    }
    
    /**
     * 记录方法退出日志
     * @param logger 日志记录器
     * @param methodName 方法名
     * @param result 返回值
     */
    public static void logMethodExit(Logger logger, String methodName, Object result) {
        if (logger.isDebugEnabled()) {
            logger.debug("Exiting method: {} with result: {}", methodName, result);
        }
    }
    
    /**
     * 记录异常日志
     * @param logger 日志记录器
     * @param message 错误消息
     * @param throwable 异常
     */
    public static void logError(Logger logger, String message, Throwable throwable) {
        logger.error(message, throwable);
    }
    
    /**
     * 记录业务操作日志
     * @param logger 日志记录器
     * @param operation 操作描述
     * @param userId 用户ID
     * @param details 详细信息
     */
    public static void logBusinessOperation(Logger logger, String operation, String userId, String details) {
        logger.info("Business Operation - {} | User: {} | Details: {}", operation, userId, details);
    }
}
