package com.ximo.springbootes.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Xim0 on 2017/7/25.
 * http请求返回的最外层对象，格式化json数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体的内容
    private Object data;

}
