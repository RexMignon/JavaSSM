package com.mignon.spring.controller;


import com.mignon.spring.annotation.Logger;
import com.mignon.spring.entity.dto.UserDTO;
import com.mignon.spring.entity.po.UserPO;
import com.mignon.spring.service.UserService;
import com.mignon.spring.common.Result;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * @author: JinQian Su
 * @desc: 测试1
 * @date: 2025-07-01 11:28
 **/
@Slf4j
@RestController
@RequestMapping(value = "/test", method = {
        RequestMethod.GET
})
@RequiredArgsConstructor
@Logger
public class JustTestController {
    //TODO JinQian Su 2025/7/1 11:40

    //FIXME
    //尝试使用lombok注入UserService

    private final UserService userService;

    @GetMapping("/t1")
    public String test() throws SQLException {
        log.info("The userService address is => {}", userService);
        userService.AddUser("<UNK>", "123456");
        return "test";
    }

    @GetMapping(value = "/t2")
    public Result<Void> test2() {
        System.out.println("====== Controller Method ENTRY =====");
        return Result.success();
    }

    @GetMapping(value = "/t3", params = {
            "name", "id"
    })
    @ApiOperation(value = "获取与返回userPO")
    public Result<UserPO> test3(UserPO userPO) {
        System.out.println(userPO);
        return Result.success(userPO);
    }

    //使用get请求来传入数组类型的数据处理方法
    //http://localhost/test/t4?args=111&args=222&args=333s
    @GetMapping("/t4")
    public Result<String> test4(String[] args) {
        String arrayByArgs = Arrays.toString(args);
        System.out.println(arrayByArgs);
        return Result.success(arrayByArgs);
    }

    //获取集合类型参数
    @PostMapping("/t5")
    public Result<String> test5(UserDTO userDTO) {
        System.out.println(userDTO);
        return Result.success("<UNK>");
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


    @PostMapping("/t6")
    public Result<String> test6(
            @Validated @RequestBody UserDTO userDTO,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            bindingResult.getAllErrors().forEach(error ->
                    errorMessages.append(error.getDefaultMessage()).append("; ")
            );
            return Result.failed("参数校验失败: " + errorMessages);
        }
        return Result.success("<UNK>");
    }


    /**
     * value:>name=xxx时会映射到username<br/>
     * required 是否必须携带该参数? <br/>
     * defaultValue,如果为null,则默认为haha<br/>
     */
    @GetMapping(value = "/t7")
    public Result<String> test7(
            @RequestParam(value = "name", required = false, defaultValue = "haha")
            String username) {
        System.out.println("username is => " + username);
        return Result.success("<UNK>");
    }


    @GetMapping(value = "/t8/{name}")
    public Result<String> test8(
            @PathVariable(value = "name", required = false)
            String username) {
        System.out.println("username is => " + username);
        return Result.success("<UNK>");
    }


    //2018/12/8
    @GetMapping(value = "/t9")
    public Result<Void> test9(@RequestParam(value = "da") Date date) {
        System.out.println(date);
        try {
            userService.AddUser(
                    "hello",
                    "123456"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();
    }

    //获取请求头信息
    //获取cookie的值
    @GetMapping(value = "/t10")
    public Result<Void> test10(@RequestHeader(value = "user-Agent", required = false)
                               String userAgent
                               //直接获取demo的cookie
            , @CookieValue(value = "demo", required = false) String cookie,
                               @RequestHeader(value = "Cookie") String cookies) {
        System.out.println(userAgent);
        System.out.println(cookie);
        System.out.println(cookies);
        try {
            userService.AddUser(
                    "hello",
                    "123456"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();
    }


    /**
     * 文件上传<br/><br/>mvc配置声明如下<br/>
     * < bean id="multipartResolver"<br/>
     * class="org.springframework.web.multipart.commons.CommonsMultipartResolver"><br/>
     * < property name="maxUploadSize" value="5242800"/><br/>
     * < property name="maxUploadSizePerFile" value="5242800"/><br/>
     * < property name="defaultEncoding" value="UTF-8"/><br/>
     * < /bean ><br/>
     * <br/>
     * <br/>
     * 需要导入commons-fileupload 和 commons-io(pom.xml)
     *
     * @param userAgent     User-Agent 简易排除Web Spider
     * @param cookie        获取JSESSIONID
     * @param name          文件传的第一个字段名称
     * @param uploadFile    文件
     * @param multipartFile 第二文件
     * @return Result<Void>
     * @see <a href="#">spring-mvc.xml</a>
     */
    @PostMapping("/t11")
    public Result<Void> test11(
            @RequestHeader(value = "user-agent") String userAgent,
            @CookieValue(value = "JSESSIONID") String cookie,
            @RequestParam(value = "username", required = false) String name,
            @RequestParam(value = "upload", required = false) MultipartFile uploadFile,
            @RequestParam(value = "uploadFile", required = false) MultipartFile multipartFile
    ) {
        log.info("username is => {}", name);
        if (Objects.isNull(uploadFile) || Objects.isNull(multipartFile)) {
            return Result.faild();
        }
        String fileName = uploadFile.getOriginalFilename();
        String fileName2 = multipartFile.getOriginalFilename();
        try {
            uploadFile.transferTo(new File("D:\\upload\\" + fileName));
            multipartFile.transferTo(new File("D:\\upload\\" + fileName2));
            return Result.success();
        } catch (IOException e) {
            log.error("An error occurred during test11: {}", e.getMessage(), e);
            return Result.faild();
        }
    }


    @PostMapping("/t12")
    public Result<Void> test12(
            @RequestHeader(value = "user-agent") String userAgent,
            @CookieValue(value = "JSESSIONID") String cookie,
            @RequestParam(value = "username", required = false) String name,
            @RequestParam(value = "upload", required = false) MultipartFile[] uploadFile
    ) {
        log.info("username is =>{} -", name);
        if (Objects.isNull(uploadFile)
                ||
                Arrays.stream(uploadFile).noneMatch(Objects::nonNull)
        ) {
            return Result.faild();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (MultipartFile file : uploadFile) {
            String fileName = file.getOriginalFilename();
            arrayList.add(fileName);
        }
        try {
            for (int i = 0; i < uploadFile.length; i++) {
                uploadFile[i].transferTo(new File("D:\\upload\\" + arrayList.get(i)));
            }

            return Result.success();
        } catch (IOException e) {
            log.error("An error occurred during test11: {}", e.getMessage(), e);
            return Result.faild();
        }
    }
}
