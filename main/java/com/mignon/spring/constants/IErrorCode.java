package com.mignon.spring.constants;


import java.io.Serializable;

public interface IErrorCode extends Serializable {
    /**
     * 返回的code码
     * @return code
     */
    int getCode();
    /**
     * 返回的消息
     * @return 消息
     */
    String getMessage();
}
