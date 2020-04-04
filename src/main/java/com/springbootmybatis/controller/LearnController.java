package com.springbootmybatis.controller;

import com.springbootmybatis.domain.LearnResource;
import com.springbootmybatis.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.applet.Applet;

@RequestMapping("/learn")
@RestController
public class LearnController {

    @Autowired
    private LearnService learnService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request){
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String url = request.getParameter("url");

        LearnResource learnResource = new LearnResource();
        learnResource.setAuthor(author);
        learnResource.setTitle(title);
        learnResource.setUrl(url);

        int index = learnService.add(learnResource);

        if(index > 0){
            return "添加成功";
        }else{
            return "添加失败";
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

}
