package com.ncu.jerry.dao;

import com.ncu.jerry.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Jiacheng on 2017/7/8.
 */
@Mapper //Spring Boot在初始化mybatis时会自动加载该mapper类。
public interface ProductDao {
    Product select(@Param("id") long id);

    void update(Product product);
}
