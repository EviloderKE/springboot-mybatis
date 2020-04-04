package com.springbootmybatis.dao;

import com.springbootmybatis.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AddressMapper {

    @Select("SELECT * FROM `address` WHERE id = #{id}")
    Address findAddressById(Long id);

}
