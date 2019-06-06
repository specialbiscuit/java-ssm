package com.abmau.quartz.exception;

import com.abmau.quartz.entity.Result;
import com.abmau.quartz.exception.exceptionClass.UserException;
import com.abmau.quartz.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof UserException){
            UserException userException = (UserException)e;
            return ResultUtil.error(userException.getCode(), userException.getMessage());
        }else {
            return ResultUtil.error(-1,"未知错误");
        }
    }

}
