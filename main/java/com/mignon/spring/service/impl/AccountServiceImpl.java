package com.mignon.spring.service.impl;


import com.mignon.spring.annotation.Logger;
import com.mignon.spring.dao.AccountDao;
import com.mignon.spring.entity.dto.AccountDTO;
import com.mignon.spring.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-09 23:32
 **/
@Service
@RequiredArgsConstructor
@Logger
@Transactional(isolation = Isolation.READ_COMMITTED)
public class AccountServiceImpl implements AccountService {


    private final AccountDao accountDao;


    @Transactional(
            transactionManager = "transactionManager",
            propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {
                    Exception.class
            }
    )
    @Override
    public void transfer(AccountDTO accountDTO) {

        accountDao.out(accountDTO);
//        int a = 1 / 0;
        accountDao.in(accountDTO);
    }


    @Override
    public HashMap<String, Double> getMoney(AccountDTO accountDTO) {
        return accountDao.getMoney(accountDTO);
    }


}
