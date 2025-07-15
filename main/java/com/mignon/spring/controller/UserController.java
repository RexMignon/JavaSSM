package com.mignon.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mignon.spring.entity.po.UserPO;
import com.mignon.spring.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @value  映射地址
 * @method 请求方式
 * @params 请求携带 (Get) http://localhost:81/user/save?username=xxx
 */
@Controller
@Slf4j
@RequestMapping(value = "/user", method = {
        RequestMethod.GET
})
@RequiredArgsConstructor
public class UserController {


    @NonNull
    private UserService userService;


    @GetMapping(value = "/save", params = {
            "username"
    })
    public String save() {
        System.out.println("Controller Running...");
        return "success";
    }

    @GetMapping("/s2")
    public ModelAndView save2() {
        log.info("In UserController,The userService through @Autowired create,And the Adress is => {}",userService);
        /**
         * Model用来封装数据的
         * View用来展示数据的
         */
        ModelAndView modelAndView = new ModelAndView();
        UserPO u = new UserPO();
        u.setId(3);
        u.setName("test");
        //设置视图数据
        modelAndView.addObject("userName", u);

        //设置视图名
        modelAndView.setViewName("success");


        return modelAndView;
    }


    @GetMapping("/s")
    public ModelAndView save3(ModelAndView modelAndView) {
        /**
         * Spring MVC 注入 ModelAndView 对象
         * */
        UserPO u = new UserPO();
        u.setId(3);
        u.setName("test4");
        //设置视图数据
        modelAndView.addObject("userName", u);

        //设置视图名
        modelAndView.setViewName("success");


        return modelAndView;
    }


    @GetMapping(value = "/save0"
    )
    public String saveQ(Model m) {
        m.addAttribute("userName", "test55");
        return "success";
    }


    @GetMapping(value = "/save1"
    )
    public void saveQ2(HttpServletResponse response) throws IOException {
        response.getWriter().print("test");
    }


    /**
     * Hello World!
     *
     * @ ResponseBody 该注解是=用来通知Controller
     * 该方法返回的是数据(data)而非视图(View)
     */
    @GetMapping(value = "/so")
    @ResponseBody
    public String s1() {
        return "Hello World";
    }


    @GetMapping(value = "j1")
    @ResponseBody
    public String jsonReturn() throws JsonProcessingException {
        /**
         * 使用Json转换工具将对象转换为Json
         * */

        UserPO userPO = new UserPO();
        userPO.setName("test");
        userPO.setId(1);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(userPO);


        return json;
    }


    @GetMapping(value = "j2")
    @ResponseBody
    //期望我的Spring MVC自动帮我转换成一个Json字符串
    public UserPO jsonReturn2() {
        /**
         * 使用Json转换工具将对象转换为Json
         * */
        UserPO userPO = new UserPO();
        userPO.setName("test");
        userPO.setId(1);
        return userPO;
    }


    @GetMapping(value = "/form")
    public String form() {
        return "form";
    }
}
