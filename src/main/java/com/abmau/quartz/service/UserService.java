package com.abmau.quartz.service;

import com.abmau.quartz.entity.UserEntity;

public interface UserService {

    UserEntity findByUserId(int userId)  throws Exception;
}
