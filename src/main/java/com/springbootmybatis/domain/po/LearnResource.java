package com.springbootmybatis.domain.po;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LearnResource {

    private Long id;

    @NotBlank(message = "author必填")
    private String author;

    @NotBlank(message = "title必填")
    private String title;

    @NotBlank(message = "url必填")
    private String url;
}
