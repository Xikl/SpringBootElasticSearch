package com.ximo.springbootes.controller;

import com.ximo.springbootes.domain.Novel;
import com.ximo.springbootes.service.LibraryService;
import com.ximo.springbootes.utils.ResultUtils;
import com.ximo.springbootes.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 朱文赵
 * 2017/9/26
 */
@RestController
@RequestMapping("/book/novel")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    /**
     * 查询方法
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") String id){
        return ResultUtils.success(libraryService.get(id));
    }

    /**
     * 添加方法
     * @param novel
     * @return
     */
    @PostMapping("/add")
    public Result add(Novel novel){
        return ResultUtils.success(libraryService.add(novel));
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") String id){
        libraryService.delete(id);
        return ResultUtils.success();
    }



}
