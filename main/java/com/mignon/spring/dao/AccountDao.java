package com.mignon.spring.dao;

import com.mignon.spring.entity.dto.AccountDTO;

import java.util.HashMap;

public interface AccountDao {

    public void out(AccountDTO accountDTO);

    public void in(AccountDTO accountDTO);

    public HashMap<String, Double> getMoney(AccountDTO accountDTO);
}
