package com.springbootmybatis.controller;

import com.springbootmybatis.domain.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@Slf4j
@RequestMapping("rest")
public class RestTemplateController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("get")
    public String get(){

        String requestUrl = UriComponentsBuilder
                .fromUriString("http://wwww.baidu.com")
                .queryParam("from", 10)
                .build()
                .toString();

        return restTemplate.getForObject(requestUrl, String.class);

    }

    @GetMapping("post")
    public String post(){

        String url = "http://wwww.baidu.com";

        User user = new User();

        /*HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);
        restTemplate.postForObject(url, httpEntity, String.class);*/

        return restTemplate.postForObject(url, user, String.class);


    }

}
