package com.abmau.quartz.dao;

import com.abmau.quartz.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserDao {

    UserEntity findByUserId(int userId);
}
