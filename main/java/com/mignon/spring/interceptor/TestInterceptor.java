package com.mignon.spring.interceptor;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author WWenHai
 * @desc: 测试拦截器,
 * preHandle()：请求处理之前,<br/>
 * <br/>
 * postHandle()：视图渲染之前<br/>
 * <br/>
 * afterCompletion()：请求完成后<br/>
 * @date: 2025-07-08 10:56
 **/
@Slf4j
public class TestInterceptor implements HandlerInterceptor {

    // 一般从配置文件获取,这里没有配置文件,直接默认token
    @Value("${app.token-name:token}")
    private String jwtCookieName;


    // 请求处理前 还未至Cotroller 主要用于认证
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Cookie[] cookies = request.getCookies();
        System.out.println(Arrays.toString(cookies));
        ObjectMapper objectMapper = new ObjectMapper();
        // 判null, 如果为null,直接拒绝 然后重定向到登录页即可
        if (Objects.isNull(cookies)) {
            return true;
        }
//        Optional<Cookie> tokenCookie = Arrays.stream(cookies)
//                .filter(cookie -> jwtCookieName.equals(cookie.getName()))
//                .findFirst();
//        if (tokenCookie.isPresent()) {
//            String tokenData = tokenCookie.get().getValue();
//            /**
//             * 这里可以先验证Token是否正确,
//             * 然后通过token取得 userName一类
//             * 再通过userName去找现在的Token是否过期
//             * 如果没过期返回true
//             * 例如Jwt
//             * */
//            log.info("这里请求的token 是:{}", tokenData);
//            return true;
//        }
//        response.setContentType("application/json;charset=utf-8");
//        String result  = objectMapper.writeValueAsString(Result.failed(
//                "请登录"
//        ));
//        response.getWriter().write(result);
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return true;
    }


    // 后置处理，可在视图渲染前修改模型。
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }


    // 收尾工作
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 已执行...");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
