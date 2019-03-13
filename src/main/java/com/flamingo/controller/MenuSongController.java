package com.flamingo.controller;

import com.flamingo.common.JsonBean;
import com.flamingo.common.MenuVo;
import com.flamingo.pojo.MenuSong;
import com.flamingo.service.MenuSongService;
import com.flamingo.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menusong")
public class MenuSongController {

    @Autowired
    private MenuSongService menuSongService;

    @RequestMapping("/addmenusong.do")
    @ResponseBody
    public JsonBean addMenuSong(MenuSong menuSong){
        JsonBean bean = null;
        try {
            menuSongService.addMenuSong(menuSong);
            bean = JsonUtils.createJsonBean(0,"歌曲已被收藏");
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(1,e.getMessage());
        }
        return bean;
    }

    @RequestMapping("/songlist.do")
    @ResponseBody
    public JsonBean findSongBYMenuId(int menuid){

        JsonBean bean = null;
        try {
            List<MenuVo> menuVos = menuSongService.selectSongByMenuId(menuid);
            bean = JsonUtils.createJsonBean(0,menuVos);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(1,e.getMessage());
        }
        return bean;
    }
}
