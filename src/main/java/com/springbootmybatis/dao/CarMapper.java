package com.springbootmybatis.dao;

import com.springbootmybatis.domain.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CarMapper {

    /**
     * 根据用户id查询所有的车
     */
    @Select("SELECT * FROM `car` WHERE user_id = #{userId}")
    List<Car> findCarByUserId(Long userId);

}
