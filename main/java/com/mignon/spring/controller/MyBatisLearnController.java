package com.mignon.spring.controller;


import com.mignon.spring.annotation.CheckParams;
import com.mignon.spring.annotation.Logger;
import com.mignon.spring.common.Result;
import com.mignon.spring.entity.dto.RUserDTO;
import com.mignon.spring.entity.vo.UserVO;
import com.mignon.spring.service.UserService;
import com.mignon.spring.utils.BindResultUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @author WWenHai
 * @desc: 学习MyBatis
 * @date: 2025-07-10 14:27
 **/
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/ba"
)
public class MyBatisLearnController {


    private final UserService userService;


    @PostMapping("/get")
    public Result<List<UserVO>> getUsersByList(
            @Validated @RequestBody RUserDTO rUserDTO
    ) {
        List<UserVO> list = userService.selectCase(rUserDTO);
        return Result.success(list);
    }


    @PostMapping("/getall")
    public Result<List<UserVO>> getAllUsers(
            @Validated @RequestBody RUserDTO rUserDTO
    ) {
        List<UserVO> list = userService.findAll();
        return Result.success(list);
    }



    @PostMapping("/add")
    public Result<Void> addUser(@Valid @RequestBody RUserDTO rUserDTO) {
        userService.add(rUserDTO);
        return Result.success();
    }


    @PostMapping(value = "/update")
    public Result<Boolean> updatePassWord(@Validated @RequestBody RUserDTO rUserDTO){
        return Result.success(userService.updatePassWd(rUserDTO));
    }


    @PostMapping(value = "/logout")
    public Result<Boolean> logout(@Valid @RequestBody RUserDTO rUserDTO,
                                  BindingResult bindingResult){
        return Result.success(userService.logoutUserByName(rUserDTO));
    }
}
