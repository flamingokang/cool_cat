package com.flamingo.controller;


import com.flamingo.common.JsonBean;
import com.flamingo.pojo.Menu;
import com.flamingo.service.MenuService;
import com.flamingo.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //通过用户id找歌单
    @RequestMapping("/findMenu.do")
    @ResponseBody
    public JsonBean findAllMenu(int uid){

        JsonBean bean = null;

        try {
            List<Menu> menu = menuService.findAllMenu(uid);
            bean = JsonUtils.createJsonBean(0,menu);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(1,e.getMessage());
        }
        return bean;
    }
}
