package com.mignon.spring.service;

import com.mignon.spring.entity.dto.AccountDTO;

import java.util.HashMap;

public interface AccountService {

    public void transfer(AccountDTO accountDTO);


    public HashMap<String, Double> getMoney(AccountDTO accountDTO);
}
