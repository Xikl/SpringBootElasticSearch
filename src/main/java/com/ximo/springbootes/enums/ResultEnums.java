package com.ximo.springbootes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by 朱文赵
 * 2017/9/5
 * 错误类型枚举
 */
@Getter
@AllArgsConstructor
public enum ResultEnums {

    //添加枚举对象
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    ID_IS_BLANK(10, "id为空"),
    NOVEL_NOT_EXIST(404, "该小说不存在"),
    UPDATE_ERROR(11, "更新book错误"),
    FORM_VALIDATION_ERROR(12, "表单验证错误"),
    ;

    private Integer code;

    private String msg;


}
