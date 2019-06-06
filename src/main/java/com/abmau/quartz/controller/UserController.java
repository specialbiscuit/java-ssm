package com.abmau.quartz.controller;

import com.abmau.quartz.entity.UserEntity;
import com.abmau.quartz.service.UserService;
import com.abmau.quartz.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public Object getUserList(@Valid UserEntity userEntity, BindingResult bindingResult) throws Exception
    {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(101, bindingResult.getFieldError().getDefaultMessage());
        }

        return userService.findByUserId(userEntity.getId());
    }

}
