package com.aku.service;

import com.aku.pojo.req.UserReq;
import com.aku.pojo.resp.BaseResp;
import com.aku.pojo.vo.User;

public interface UserService {
    BaseResp sendMail(String email);

    BaseResp registry(UserReq userReq);

    BaseResp login(UserReq user);

    BaseResp updatePassword(User user);

    BaseResp findAll();

    BaseResp deleteByUserName(Integer id);
}
