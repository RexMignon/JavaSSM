package com.mignon.spring.mapper;


import com.mignon.spring.domain.User;
import com.mignon.spring.entity.dto.RUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-08 13:28
 **/

public interface UserMapper {
    public List<User> findAll();

    public void add(RUserDTO userDTO);

    public Integer updatePassWd(RUserDTO userDTO);

    public User selectUserByName(@Param("name") String name);

    public Integer deleteUserById(@Param("id") Integer id);

    public List<User> selectCase(RUserDTO userDTO);

    public List<User> selectIds(Integer ...id);
//    或者List<Integer> id
}
