package com.springbootmybatis.dao;

import com.springbootmybatis.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    @Insert("insert into user(name) values(#{name})")
    int add(User user);

    /*@Select("SELECT * FROM `user` where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nickname", column = "nick_name"),
            @Result(property = "addressId", column = "address_id"),
            @Result(
                    property = "address",
                    column = "address_id", one = @One(select = "com.springbootmybatis.dao.AddressMapper.findAddressById", fetchType = FetchType.EAGER))
    })
    User findUserWithAddress(@Param("id") Long id);*/

    @Select("SELECT u.id,u.nick_name,u.address_id,a.province,a.city FROM `user` u left join `address` a on u.address_id = a.id where u.id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nickname", column = "nick_name"),
            @Result(property = "addressId", column = "address_id"),
            @Result(property="address.province", column="province"),
            @Result(property="address.city", column="city"),
    })
    User findUserWithAddress(@Param("id") Long id);


    @Select("select * from `user`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nickname", column = "nick_name"),
            @Result(property = "addressId", column = "address_id"),
            @Result(
                    property = "address",
                    column = "address_id",
                    one = @One(select = "com.springbootmybatis.dao.AddressMapper.findAddressById", fetchType = FetchType.EAGER))
    })
    List<User> getAllUserInfo();

    @Select("SELECT * FROM `user` WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "nickname", column = "nick_name"),
            @Result(property = "addressId", column = "address_id"),
            @Result(
                    property = "cars",
                    column = "id",
                    many = @Many(select = "com.springbootmybatis.dao.CarMapper.findCarByUserId", fetchType = FetchType.EAGER))
    })
    User getUserWithCar(Long id);
}
