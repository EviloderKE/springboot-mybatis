package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springbootmybatis.po.LearnResource;
import com.springbootmybatis.service.LearnService;
import com.springbootmybatis.vo.result.FailResult;
import com.springbootmybatis.vo.result.Result;
import com.springbootmybatis.vo.result.SuccessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RequestMapping("/learn")
@RestController
public class LearnController {

    @Autowired
    private LearnService learnService;

    @PostMapping(value = "/add")
    public Result add(@Valid LearnResource learnResource){
        int index = learnService.add(learnResource);

        if(index > 0){
            return new SuccessResult<>();
        }else{
            return new FailResult<>();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request){
        String id = request.getParameter("id");

        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String url = request.getParameter("url");

        LearnResource learnResource = learnService.queryById(Long.valueOf(id));
        learnResource.setAuthor(author);
        learnResource.setTitle(title);
        learnResource.setUrl(url);

        int index = learnService.update(learnResource);

        if(index > 0){
            return "修改成功";
        }else{
            return "修改失败";
        }

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request){

        String ids = request.getParameter("ids");

        String[] idArr = ids.split(",");

        int index = 0;
        System.out.println(idArr.length);
        if(idArr.length > 1){

            index = learnService.deleteByIds(ids);;
        }else{
            index = learnService.deleteById(idArr[0]);
        }

        if(index > 0){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "2";
    }

    @PostMapping("/list")
    public String list(){
        log.info(String.valueOf(1111));

        log.info("Set score {} for Person {} ok.", 1, 22);

        int startPage= 2;
        int pageSize= 2;

        PageHelper.startPage(startPage, pageSize);
        PageHelper.orderBy("id ASC");

        PageInfo<LearnResource> pageInfo = new PageInfo<>(learnService.queryLearnResourceList());

        //List<LearnResource> list = learnService.queryLearnResourceList();


        String jsonString = JSON.toJSONString(pageInfo);

        return jsonString;
    }

}
