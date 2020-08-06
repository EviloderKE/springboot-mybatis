package com.springbootmybatis.controller;

import com.alibaba.excel.EasyExcel;
import com.springbootmybatis.Excel.UserExcelListener;
import com.springbootmybatis.qo.UserExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("easyexcel")
@Slf4j
public class EasyExcelController {

    @PostMapping("upload")
    public String upload(MultipartFile file) throws IOException {
        //EasyExcel.read(file.getInputStream(), UserExcel.class, new UserExcelListener()).sheet().headRowNumber(指定行).doRead();
        EasyExcel.read(file.getInputStream(), UserExcel.class, new UserExcelListener()).sheet().doRead();
        return "success";
    }

}
