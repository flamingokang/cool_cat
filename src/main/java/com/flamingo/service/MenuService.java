package com.flamingo.service;

import com.flamingo.pojo.Menu;
import com.flamingo.pojo.User;

import java.util.List;

public interface MenuService {
    //用户名作为参数查找该用户的所有歌单
    List<Menu> findAllMenu(int uid);
}
