package com.mignon.spring.constants;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BaseErrorCode implements IErrorCode {

    /** 公共错误 */
    PARAM_MISS_ERROR(BaseErrorCode.PARAM_MISS_CODE, "缺少必要的请求参数"),
    PARAM_TYPE_ERROR(BaseErrorCode.PARAM_TYPE_ERROR_CODE, "请求参数类型错误"),
    PARAM_BIND_ERROR(BaseErrorCode.PARAM_BIND_ERROR_CODE, "请求参数绑定错误"),
    PARAM_VALID_ERROR(BaseErrorCode.PARAM_VALID_ERROR_CODE, "请求参数格式不合规则"),
    PARAM_REPEAT_ERROR(BaseErrorCode.PARAM_REPEAT_ERROR_CODE, "请求参数重复"),
    METHOD_NOT_SUPPORTED_ERROR(BaseErrorCode.METHOD_NOT_SUPPORTED_CODE, "不支持当前请求方法"),
    MEDIA_TYPE_NOT_SUPPORTED_ERROR(BaseErrorCode.MEDIA_TYPE_NOT_SUPPORTED_CODE, "不支持当前媒体类型"),
    MEDIA_TYPE_NOT_ACCEPT_ERROR(BaseErrorCode.MEDIA_TYPE_NOT_ACCEPT_CODE, "不接受的媒体类型"),

    DATA_NOT_EXIST_ERROR(BaseErrorCode.DATA_NOT_EXIST_CODE, "数据不存在"),
    DATA_EXISTED_ERROR(BaseErrorCode.DATA_EXISTED_CODE, "数据已存在"),
    DATA_ADD_ERROR(BaseErrorCode.DATA_ADD_FAILED_CODE, "数据添加失败,请重试或联系管理员！"),
    DATA_UPDATE_ERROR(BaseErrorCode.DATA_UPDATE_FAILED_CODE, "数据更新失败,请重试或联系管理员！"),
    DATA_DELETE_ERROR(BaseErrorCode.DATA_DELETE_FAILED_CODE, "数据删除失败,请重试或联系管理员！"),
    DATA_IMPORT_ERROR(BaseErrorCode.DATA_IMPORT_FAILED_CODE, "数据导入失败,请重试或联系管理员！"),
    DATA_EXPORT_ERROR(BaseErrorCode.DATA_EXPROT_FAILED_CODE, "数据导出失败,请重试或联系管理员！"),
    ACCESS_DEFINED_ERROR(BaseErrorCode.ACCESS_DEFINED_FAILED_CODE, "非法访问，没有认证！"),
    UNAUTHORIZED_ERROR(BaseErrorCode.UNAUTHORIZED_FAILED_CODE, "权限不够！");

    /***********通用 异常 code*******/

    /**
     * 缺少必要的请求参数
     */
    public static final int PARAM_MISS_CODE = 10001;
    /**
     * 请求参数类型错误
     */
    public static final int PARAM_TYPE_ERROR_CODE = 10002;
    /**
     * 请求参数绑定错误
     */
    public static final int PARAM_BIND_ERROR_CODE = 10003;
    /**
     * 参数校验失败
     */
    public static final int PARAM_VALID_ERROR_CODE = 10004;
    /**
     * 请求参数绑定错误
     */
    public static final int PARAM_REPEAT_ERROR_CODE = 10005;

    /**
     * 不支持当前请求方法
     */
    public static final int METHOD_NOT_SUPPORTED_CODE = 10006;

    /**
     * 不接受的文件类型
     */
    public static final int MEDIA_TYPE_NOT_ACCEPT_CODE = 10007;

    /**
     * 不支持当前文件类型
     */
    public static final int MEDIA_TYPE_NOT_SUPPORTED_CODE = 10008;


    /***********通用 数据 code*******/

    /**
     * 数据不存在
     */
    public static final int DATA_NOT_EXIST_CODE = 20001;
    /**
     * 数据已存在
     */
    public static final int DATA_EXISTED_CODE = 20003;
    /**
     * 数据添加失败
     */
    public static final int DATA_ADD_FAILED_CODE = 20004;
    /**
     * 数据更新失败
     */
    public static final int DATA_UPDATE_FAILED_CODE = 20005;
    /**
     * 数据删除失败
     */
    public static final int DATA_DELETE_FAILED_CODE = 20006;
    /**
     * 数据导入失败
     */
    public static final int DATA_IMPORT_FAILED_CODE = 20007;
    /**
     * 数据导出失败
     */
    public static final int DATA_EXPROT_FAILED_CODE = 20008;

    // -----------------通用 权限 code-----------------
    /**
     * 非法访问，没有认证
     */
    public static final int ACCESS_DEFINED_FAILED_CODE = 30001;

    /**
     * 权限不够
     */
    public static final int UNAUTHORIZED_FAILED_CODE = 30002;

    /**
     * code编码
     */
    final int code;
    /**
     * 中文信息描述
     */
    final String message;

    /**
     * 通过@AllArgsConstructor生成构造器,然后就可以直接使用
     * */
}
