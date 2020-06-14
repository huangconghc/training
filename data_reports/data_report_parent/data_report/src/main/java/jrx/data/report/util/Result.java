package jrx.data.report.util;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description Result
 * @Author xiaocongcong
 * @Date 2020/6/10
 */
public class Result<T> implements Serializable{


    /**
     * @Description:是否成功
     */
    private boolean flag;
    /**
     * @Description:状态码
     */
    private Integer code;
    /**
     * @Description:返回消息
     */
    private String message;
    /**
     * @Description: 返回数据
     * @Param:
     * @Return:
     */
    private T data;

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = (T) data;
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result() {
        this.flag = true;
        this.code = StatusCode.OK;
        this.message = "操作成功!";
    }

    public static Result success(String message) {
        return new Result(true, StatusCode.OK, message);
    }

    public static <T> Result<T> success(T t) {
        return new Result<>(true, StatusCode.OK, "", t);
    }

    public static <T> Result<T> success(String message, T t) {
        return new Result<>(true, StatusCode.OK, message, t);
    }

    public static Result error(String message) {
        return new Result(false, StatusCode.ERROR, message);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}