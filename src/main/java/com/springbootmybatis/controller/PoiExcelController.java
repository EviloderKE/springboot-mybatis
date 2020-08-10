package com.springbootmybatis.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("poiExcel")
public class PoiExcelController {

    @GetMapping("write")
    public void write() throws Exception {


    }

}
