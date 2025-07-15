package com.mignon.spring.common;

import com.mignon.spring.constants.SystemCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author Hydra
 */
@Data
@ApiModel("系统响应体")
@NoArgsConstructor //无参构造器生成
@AllArgsConstructor //所有参数自动注入
@Builder
public class Result<T> {

    private static final String FAILD_MSG = "FAIL";

    private static final String SUCCESS_MSG = "OK";

    /**
     * 接口响应结果描述
     */
    @ApiModelProperty(value = "接口响应结果描述", required = true, example = SUCCESS_MSG)
    private String msg;

    /**
     * 系统响应码
     *
     * @see SystemCodeEnum
     */
    @ApiModelProperty(value = "系统响应码", required = true, example = "200")
    private Integer code;

    /**
     * 接口响应的数据
     */
    @ApiModelProperty(value = "接口的响应数据", required = true)
    private T data;

    /**
     * 成功的接口响应
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(SystemCodeEnum.SUCCESS.code());
        result.setData(data);
        result.setMsg(SystemCodeEnum.SUCCESS.msg());
        return result;
    }

    /**
     * 添加返回信息
     *
     * @param data
     * @param message
     * @return
     */
    public static <T> Result<T> success(T data, String message) {
        Result<T> result = new Result<>();
        result.setCode(SystemCodeEnum.SUCCESS.code());
        result.setData(data);
        result.setMsg(message);
        return result;
    }

    /**
     * 成功的接口响应
     *
     * @return
     */
    public static <T> Result<T> success() {
        return success(null);
    }

    /**
     * 失败的接口响应
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> faild() {
        Result<T> result = new Result<>();
        result.setCode(SystemCodeEnum.SYSTEM_ERROR.code());
        result.setData(null);
        result.setMsg(SystemCodeEnum.SYSTEM_ERROR.msg());
        return result;
    }

    /**
     * 失败的接口响应
     *
     * @param codeEnum
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(SystemCodeEnum codeEnum) {
        Result<T> result = new Result<>();
        result.setCode(codeEnum.code());
        result.setData(null);
        result.setMsg(codeEnum.msg());
        return result;
    }

    /**
     * 失败的接口响应
     *
     * @param msg
     * @param <T>
     * @return Result
     */
    public static <T> Result<T> failed(String msg) {
        Result<T> result = new Result<>();
        result.setCode(SystemCodeEnum.SYSTEM_ERROR.code());
        result.setData(null);
        result.setMsg(msg);
        return result;
    }

    /**
     * @param message
     * @param errorcode
     * @return
     */
    public static <T> Result<T> failed(String message, Integer errorcode) {
        Result<T> result = new Result<>();
        result.setCode(errorcode);
        result.setData(null);
        result.setMsg(message);
        return result;
    }

    /**
     * 判定响应结果是否正确
     */
    public boolean isSuccess() {
        if (Objects.isNull(this.code)) {
            return false;
        }
        return this.code == SystemCodeEnum.SUCCESS.code();
    }

}
