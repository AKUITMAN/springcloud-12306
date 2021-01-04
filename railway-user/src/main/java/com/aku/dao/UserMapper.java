package com.aku.dao;

import com.aku.pojo.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper {
    User findByEmail(String email);

    Integer updatePassword(Integer id,String password);

    int deleteByUserName(@Param("id") Integer id);
}
