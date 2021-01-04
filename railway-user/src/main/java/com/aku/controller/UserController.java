package com.aku.controller;

import com.aku.pojo.req.UserReq;
import com.aku.pojo.resp.BaseResp;
import com.aku.pojo.vo.User;
import com.aku.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/sendMail",method = RequestMethod.POST)
    public BaseResp sendMail(@RequestBody Map map){
        return userService.sendMail(map.get("email").toString());

    }
    @RequestMapping(value = "/registry",method = RequestMethod.POST)
    public BaseResp registry(@RequestBody UserReq userReq){
        return userService.registry(userReq);
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResp login(@RequestBody UserReq user){
        return userService.login(user);
    }

    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public BaseResp updatePassword(@RequestBody User user){
        return userService.updatePassword(user);
    }
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @RequiresPermissions(value = {"/user/findAll"})
    public BaseResp findAll(){
        return userService.findAll();
    }
    @RequestMapping(value = "deleteByuserName",method =RequestMethod.POST)
    @RequiresPermissions(value = {"/user/deleteByUserName"})
    public BaseResp deleteByUserName(@RequestBody Map map){
        Integer id= (Integer) map.get("id");
        System.out.println(id);
        return userService.deleteByUserName(id);
    }
}
