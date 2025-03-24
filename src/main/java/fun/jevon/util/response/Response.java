package fun.jevon.util.response;

import lombok.Data;

// Api返回类,<T>任意数据类型
@Data
public class Response<T> {
    // 状态码
    private int code;
    // 消息
    private String message;
    // 数据<T>任意类型
    private T data;

    // 无参构造方法
    public Response(){}

    // 全参构造方法
    public Response(int code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 声明方法，第一个<T>声明方法是泛类型方法
    // 默认返回200及成功信息+泛类型数据
    public static <T> Response<T> succes(T data) {
        return new Response<>(200, "成功", data);
    }

    // 错误返回
    public static <T> Response<T> error(int code, String message) {
        return new Response<>(code, message, null);
    }
}
