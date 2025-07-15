package com.mignon.spring.controller;


import com.mignon.spring.annotation.Logger;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JinQian Su
 * @desc: 用来返回视图
 * @date: 2025-07-02 00:59
 **/
@Slf4j
@RequestMapping("/")
@Controller
@AllArgsConstructor
@Logger
public class ViewContorller {

    @GetMapping("/ajax")
    public String ajax(){
        return "ajax";
    }

    @GetMapping(
            value = "upload"
    )
    public String upload(@NonNull @RequestHeader(value = "user-Agent") String ua){
        return "upload";
    }



        @GetMapping("/ts1")
    public void doSomething() {
        log.info("Executing doSomething method.");
//        try {
            // 模拟一些操作
            int result = 10 / 0;
            // 模拟一个异常
//        } catch (ArithmeticException e) {
//            // 测试Slf4j
//            log.error("An error occurred during doSomething: {}", e.getMessage(), e);
//        }
        log.debug("Debug message: variable value is X.");
        log.trace("Trace message: entering method.");
    }
}
