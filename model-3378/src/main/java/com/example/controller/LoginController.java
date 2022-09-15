package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.xo.dto.Result;
import com.example.xo.entity.zb.ZbUser;
import com.example.xo.service.zbdb.user.ZbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: Lc
 * @Date: 2021-11-17
 * @apiNote
 */
@Controller
public class LoginController {
    @Autowired
    private ZbUserService zbUserService;

    @CrossOrigin
    @PostMapping(value = "/admin/login")
    @ResponseBody
    public Result login(@RequestBody ZbUser requestUser, HttpSession session) {
        String username = requestUser.getUserName();
//        username = HtmlUtils.htmlEscape(username);
//        if (!requestUser.getPassWord().equals("123456")) {
//            return Result.error();
//        } else {
//            //用户对象User添加到session中
////            session.setAttribute("userinfo", requestUser);
//            return Result.success();
//        }
        return Result.success();

    }


    @CrossOrigin
    @GetMapping(value = "/admin/home")
    @ResponseBody
    public Result home(@RequestBody ZbUser requestUser, HttpSession session) {
       return Result.success("[{\"date\":\"2016-05-02\",\"name\":\"王小虎\",\"address\":\"上海市普陀区金沙江路 1518 弄\"},{\"date\":\"2016-05-04\",\"name\":\"王小虎\",\"address\":\"上海市普陀区金沙江路 1517 弄\"}]");
    }

    @GetMapping(value = "/admin/getList")
    @ResponseBody
    public Result getList(HttpServletRequest request) {
        return Result.success(zbUserService.getList(request));
    }

    @GetMapping(value = "/admin/getByEntity")
    @ResponseBody
    public Result getByEntity(ZbUser zbUser, Long page, Integer size) {
        return Result.success(zbUserService.getByEntity(zbUser, page, size));
    }
}
