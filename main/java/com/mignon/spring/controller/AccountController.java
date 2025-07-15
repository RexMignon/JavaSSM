package com.mignon.spring.controller;


import com.mignon.spring.annotation.Logger;
import com.mignon.spring.entity.dto.AccountDTO;
import com.mignon.spring.service.AccountService;
import com.mignon.spring.common.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-09 23:34
 **/
@RestController
@Logger
@RequiredArgsConstructor
@RequestMapping(value = "/ac", method = {
        RequestMethod.POST
})
public class AccountController {

    @Lazy
    private final AccountService accountService;

    @PostMapping("/tr")
    public Result<Boolean> transfer(@Validated @RequestBody AccountDTO accountDTO,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            bindingResult.getAllErrors().forEach(error ->
                    errorMessages.append(error.getDefaultMessage()).append("; ")
            );
            return Result.failed("参数校验失败: " + errorMessages);
        }
        if (accountDTO.getOutMan().equals(accountDTO.getInMan())) {
            return Result.failed("不得向自己转账");
        }
        accountService.transfer(accountDTO);
        return Result.success(true);
    }

    @PostMapping("/get")
    public Result<HashMap<String, Double>> ghetMoney(@Validated @RequestBody AccountDTO accountDTO,
                                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessages = new StringBuilder();
            bindingResult.getAllErrors().forEach(error ->
                    errorMessages.append(error.getDefaultMessage()).append("; ")
            );
            return Result.failed("参数校验失败: " + errorMessages);
        }
        return Result.success(accountService.getMoney(accountDTO));
    }
}
