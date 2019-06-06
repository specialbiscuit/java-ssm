package com.abmau.quartz.service.impl;

import com.abmau.quartz.dao.UserDao;
import com.abmau.quartz.entity.ResultEnum;
import com.abmau.quartz.entity.UserEntity;
import com.abmau.quartz.exception.exceptionClass.UserException;
import com.abmau.quartz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity findByUserId(int userId) throws Exception{

        logger.info("用户ID:" + userId);
        UserEntity user = userDao.findByUserId(userId);

        if(user.getAge() < 10) {
            throw new UserException(ResultEnum.PRIMARY_SCHOOL);
        }

        logger.info(user.toString());

        return user;
    }
}
