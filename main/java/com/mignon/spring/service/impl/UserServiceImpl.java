package com.mignon.spring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mignon.spring.annotation.Logger;
import com.mignon.spring.dao.UserDao;
import com.mignon.spring.domain.User;
import com.mignon.spring.entity.dto.RUserDTO;
import com.mignon.spring.entity.po.RUserPO;
import com.mignon.spring.entity.vo.UserVO;
import com.mignon.spring.mapper.UserMapper;
import com.mignon.spring.service.UserService;
import com.mignon.spring.utils.Sm3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Scope("prototype")
@RequiredArgsConstructor
@Primary
@Logger
@Transactional(rollbackFor = Exception.class,
        isolation = Isolation.READ_COMMITTED,
        propagation = Propagation.REQUIRED
)

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private final UserMapper userMapper;

    @Override
    public boolean AddUser(String name, String password) throws SQLException {
        return userDao.AddUser(name, password);
    }

    @Override
    public List<UserVO> findAll() {
        PageHelper.startPage(1,3);
        List<User> list = userMapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getNextPage());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getTotal());

        List<UserVO> userVOList = new ArrayList<>();
        list.forEach(n ->
                {
                    Integer id = n.getId();
                    String password = n.getPassword();
                    String name = n.getName();
                    UserVO userVO = new UserVO();
                    userVO.setName(name);
                    userVO.setToken(Sm3Util.hash(
                            id, password, name
                    ));
                    userVOList.add(userVO);
                }
        );
        return userVOList;
    }


    @Override
    public void add(RUserDTO userDTO) {
        userMapper.add(userDTO);
    }

    @Override
    public Boolean updatePassWd(RUserDTO userDTO) {
        return userMapper.updatePassWd(userDTO) > 0;
    }

    @Override
    public Boolean logoutUserByName(RUserDTO userDTO) {
        User user = userMapper.selectUserByName(userDTO.getName());
        if (Objects.nonNull(user) &&user.getPassword().equals(userDTO.getPassword())) {
            return userMapper.deleteUserById(user.getId()) > 0;
        }
        // 用户不存在或密码错误
        return false;
    }

    @Override
    public List<UserVO> selectCase(RUserDTO userDTO) {
        List<User> list = userMapper.selectCase(userDTO);
        List<UserVO> userVOList = new ArrayList<>();
        list.forEach(n ->
                {
                    Integer id = n.getId();
                    String password = n.getPassword();
                    String name = n.getName();
                    UserVO userVO = new UserVO();
                    userVO.setName(name);
                    userVO.setToken(Sm3Util.hash(
                            id, password, name
                    ));
                    userVOList.add(userVO);
                }
        );
        return userVOList;
    }
}




