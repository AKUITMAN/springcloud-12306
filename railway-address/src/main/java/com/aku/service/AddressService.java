package com.aku.service;


import com.aku.pojo.resp.BaseResp;
import com.aku.pojo.vo.Address;

public interface AddressService {
    BaseResp findAll();
    BaseResp findById(Integer id);
    BaseResp deleteById(Integer id);
    BaseResp saveOrFlush(Address address);

    BaseResp findMap();
}
