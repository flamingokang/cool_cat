package com.flamingo.dao;

import com.flamingo.pojo.Menu;
import com.flamingo.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查找用户的所有歌单
    List<Menu> findAllMenu();
}