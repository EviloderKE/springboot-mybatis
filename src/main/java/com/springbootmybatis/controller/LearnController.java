package com.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springbootmybatis.domain.po.LearnResource;
import com.springbootmybatis.service.LearnService;
import com.springbootmybatis.domain.result.ErrorResult;
import com.springbootmybatis.domain.result.Result;
import com.springbootmybatis.domain.result.SuccessResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RequestMapping("/learn")
@RestController
public class LearnController {

    @Autowired
    private LearnService learnService;

    /**
     * post发生表单请求
     * 不传递参数
     * 不加@valid 对象会初始化，
     * 加@Vailid BindException
     * @param learnResource
     * @return
     */
    @PostMapping(value = "/add")
    public Result add(@Valid LearnResource learnResource){
        int index = learnService.add(learnResource);

        if(index > 0){
            return new SuccessResult<>();
        }else{
            return new ErrorResult<>();
        }
    }

    @PostMapping(value = "/addBody")
    public Result addBody(@Valid @RequestBody LearnResource learnResource){
        int index = learnService.add(learnResource);

        if(index > 0){
            return new SuccessResult<>();
        }else{
            return new ErrorResult<>();
        }
    }

    @PostMapping(value = "/test")
    public LearnResource test(LearnResource learnResource){
        learnResource.setAuthor("abc");
        return learnResource;
    }

    @PostMapping(value = "/update")
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

    @PostMapping(value = "/delete")
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
