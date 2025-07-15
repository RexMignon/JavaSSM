package com.mignon.spring.resolver;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author WWenHai
 * @desc: 自定义异常处理器
 * @date: 2025-07-08 23:41
 **/
public class MyExceptionResolver implements HandlerExceptionResolver {

    /**
     * @param e Exception 异常
     * @param httpServletRequest 请求
     * @param httpServletResponse 响应
     * @param o
     * @return
     * @see HandlerExceptionResolver
     * */
    @Override
    public ModelAndView resolveException(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object o,
            Exception e) {
        Class<?> handlerClass = null;
        if (Objects.nonNull(o)) {
            handlerClass = o.getClass();
            System.out.println("发生异常的处理程序类型是：" + handlerClass.getName());
        }
        ModelAndView mav = new ModelAndView();
        if (e instanceof ArithmeticException){
            mav.addObject("error","除数不可以为0");
        }
        mav.setViewName("error");
        return mav;
    }
}
