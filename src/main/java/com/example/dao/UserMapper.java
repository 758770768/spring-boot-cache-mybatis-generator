package com.example.dao;

import org.springframework.cache.annotation.Cacheable;

import com.example.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    @Cacheable(value="users",key="#p0")
    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}