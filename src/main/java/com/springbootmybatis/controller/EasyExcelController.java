package com.springbootmybatis.controller;

import com.alibaba.excel.EasyExcel;
import com.springbootmybatis.excel.UserExcelListener;
import com.springbootmybatis.domain.qo.ExportExcel;
import com.springbootmybatis.domain.qo.UserExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

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

    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        ArrayList<ExportExcel> al = new ArrayList<>();
        ExportExcel u1 = new ExportExcel();
        u1.setAge(24);
        u1.setName("zk");
        al.add(u1);

        ExportExcel u2 = new ExportExcel();
        u2.setAge(20);
        u2.setName("zk1");
        al.add(u2);

        EasyExcel.write(response.getOutputStream(), ExportExcel.class).sheet("模板").doWrite(al);
    }

}
