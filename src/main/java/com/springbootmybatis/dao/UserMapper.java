package com.springbootmybatis.dao;

import com.springbootmybatis.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    @Insert("insert into user(name) values(#{name})")
    int add(User user);

    @Select("SELECT * FROM `user` where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nickname", column = "nick_name"),
            @Result(
                    property = "address",
                    column = "address_id", one = @One(select = "com.springbootmybatis.dao.AddressMapper.findAddressById", fetchType = FetchType.EAGER))
    })
    /*@Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nickname", column = "nick_name"),
    })*/
    User findUserWithAddress(@Param("id") Long id);
}
