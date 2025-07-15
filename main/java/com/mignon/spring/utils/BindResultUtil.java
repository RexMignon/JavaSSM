package com.mignon.spring.utils;

import com.mignon.spring.common.Result;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;



/**
 * @author WWenHai
 * @desc: 参数校验工具类
 * @date: 2025-07-10 14:32
 **/
public class BindResultUtil {

    /**
     * 检查 BindingResult 是否有错误，如果存在则返回一个表示失败的 String 。
     * @param bindingResult Spring 验证结果对象
     * @return 如果有验证错误则返回包含错误信息的 String 对象，否则返回 null。
     */
    public static String getValidationErrors(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            bindingResult.getAllErrors().forEach(error ->
                    errorMessages.append(error.getDefaultMessage()).append("; ")
            );
            if (errorMessages.length() > 0) {
                errorMessages.setLength(errorMessages.length() - 2);
            }
            return errorMessages.toString();
        } else {
            return null;
        }
    }

}