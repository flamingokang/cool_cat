package com.flamingo.service.impl;

import com.flamingo.dao.MenuMapper;
import com.flamingo.pojo.Menu;
import com.flamingo.pojo.User;
import com.flamingo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuDao;

    //实现用户id找歌单列表
    @Override
    public List<Menu> findAllMenu(int uid) {

        List<Menu> menu = menuDao.findAllMenu(uid);

        return menu;
    }
}
