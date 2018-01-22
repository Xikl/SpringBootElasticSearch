package com.ximo.springbootes.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 添加校正信息
 * Created by 朱文赵
 * 2017/9/26
 */
@Data
public class Novel {

    @NotBlank(message = "标题不能为空")
    private String title;

    @NotBlank(message = "作者不能为空")
    private String author;

    @NotNull(message = "字数统计不能为空")
    private Integer wordCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishDate;

}
