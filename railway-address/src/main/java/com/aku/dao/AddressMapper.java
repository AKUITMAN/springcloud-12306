package com.aku.dao;

import com.aku.pojo.req.AddressReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    List<AddressReq> findMap();
}
