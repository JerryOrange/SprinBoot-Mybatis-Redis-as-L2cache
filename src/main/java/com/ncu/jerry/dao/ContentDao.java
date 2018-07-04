package com.ncu.jerry.dao;

import com.ncu.jerry.entity.Content;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Jiacheng on 2018/7/3.
 */
@Mapper
public interface ContentDao {

    List<Content> selectByCategoryId(Long categoryId);
}
