package com.ximo.springbootes.handle;


import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.ximo.springbootes.enums.ResultEnums;
import com.ximo.springbootes.exception.LibraryException;
import com.ximo.springbootes.utils.ResultUtils;
import com.ximo.springbootes.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Created by 朱文赵
 * 2017/9/5
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandle {

    /**
     * 全局处理异常方法
     * @param e 所有的异常
     * @return Result
     */
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e){
        //判断为LibraryException的子类
        if(e instanceof LibraryException){
            LibraryException libraryException = (LibraryException) e;
            return ResultUtils.error(libraryException.getCode(), libraryException.getMessage());
        }else{//其他错误
            log.error("【系统异常】 {}", e);
            return ResultUtils.error(ResultEnums.UNKNOWN_ERROR);
        }
    }

}
