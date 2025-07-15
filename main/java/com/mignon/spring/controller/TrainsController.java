package com.mignon.spring.controller;


import com.mignon.spring.annotation.Logger;
import com.mignon.spring.common.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author JinQian Su
 * @desc: 练习MVC请求
 * @date: 2025-07-07 09:23
 **/

@RestController
@RequestMapping("/tr")
@RequiredArgsConstructor
@Slf4j
@Logger
public class TrainsController {

    //TODO 使用get传入数组
    @GetMapping("/t1")
    public Result<Void> getStringArgs(
            @RequestParam(value = "args", required = false) String[] args
    ){
        log.info("args={}", Arrays.toString(args));

        return Result.success();
    }
    //TODO 使用POST传入数组

    @PostMapping("/t2")
    public Result<Void> postStringArgs(
        @RequestParam(value = "args", required = false) String[] args
    ){

        System.out.println(Arrays.toString(args));
        return Result.success();
    }


}
