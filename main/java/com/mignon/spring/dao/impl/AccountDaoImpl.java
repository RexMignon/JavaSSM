package com.mignon.spring.dao.impl;


import com.mignon.spring.annotation.Logger;
import com.mignon.spring.dao.AccountDao;
import com.mignon.spring.entity.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-09 23:28
 **/


@Repository
@RequiredArgsConstructor
@Logger

public class AccountDaoImpl implements AccountDao {


    private final JdbcTemplate jdbcTemplate;

    @Override
    public void out(AccountDTO accountDTO) {
        String outMan = accountDTO.getOutMan();
        Double money = accountDTO.getMoney();
        jdbcTemplate.update("UPDATE account SET money = money - ? WHERE name = ?;",money,outMan);
    }

    @Override
    public void in(AccountDTO accountDTO) {
        String inMan = accountDTO.getInMan();
        Double money = accountDTO.getMoney();
         jdbcTemplate.update("UPDATE account SET money = money + ? WHERE name = ?;",money,inMan);
    }

    @Override
    public HashMap<String, Double> getMoney(AccountDTO accountDTO) {
        String outMan = accountDTO.getOutMan();
        String inMan = accountDTO.getInMan();
        Double out = jdbcTemplate.queryForObject("SELECT money FROM account WHERE name = ?",Double.class, outMan);
        HashMap<String, Double> money = new HashMap<>();
        money.put(outMan, out);
        Double in = jdbcTemplate.queryForObject("SELECT money FROM account WHERE name = ?",Double.class, inMan);
        money.put(inMan, in);
        return money;
    }
}
