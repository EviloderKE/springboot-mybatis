package com.springbootmybatis.dao;

import com.springbootmybatis.domain.LearnResource;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface LearnMapper {
    @Insert("insert into learn_resource(author, title,url) values(#{author},#{title},#{url})")
    int add(LearnResource learnResource);

    @Update("update learn_resource set author=#{author},title=#{title},url=#{url} where id = #{id}")
    int update(LearnResource learnResource);

    //column 数据库字段 property 实体属性
    @Select("select * from learn_resource where id = #{id}")
    @Results(id = "learnMap", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(column = "author", property = "author", javaType = String.class),
            @Result(column = "title", property = "title", javaType = String.class)
    })
    LearnResource queryById(@Param("id") Long id);

    @Delete("delete from learn_resource where id = #{id}")
    int deleteById(String id);

    @Delete("delete from learn_resource where id in (${ids})")
    int deleteByIds(@Param("ids") String ids);
}
