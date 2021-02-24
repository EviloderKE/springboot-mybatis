package com.springbootmybatis.dao;

import com.springbootmybatis.domain.po.Address;
import org.apache.ibatis.annotations.Select;

public interface AddressMapper {

    @Select("SELECT * FROM `address` WHERE id = #{id}")
    Address findAddressById(Long id);

}
