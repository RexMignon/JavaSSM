package com.mignon.spring.service;


import com.mignon.spring.entity.dto.RUserDTO;
import com.mignon.spring.entity.po.RUserPO;
import com.mignon.spring.entity.vo.UserVO;

import java.sql.SQLException;
import java.util.List;


public interface UserService {
    boolean AddUser(String name,String password) throws SQLException;

    public List<UserVO> findAll();

    public void add(RUserDTO userDTO);

    public Boolean updatePassWd(RUserDTO userDTO);

    public Boolean logoutUserByName(RUserDTO  userDTO);

    public List<UserVO> selectCase(RUserDTO userDTO);
}
