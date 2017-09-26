package com.ximo.springbootes.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 朱文赵
 * 2017/9/26
 */
@Data
public class Novel {

    private String title;

    private String author;

    private Integer wordCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishDate;

}
