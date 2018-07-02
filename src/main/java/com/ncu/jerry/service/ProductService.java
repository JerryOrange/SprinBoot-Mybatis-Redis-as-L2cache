package com.ncu.jerry.service;

import com.ncu.jerry.dao.ProductDao;
import com.ncu.jerry.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jiacheng on 2017/7/8.
 */
@Service
@Transactional(readOnly = true)
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public Product select(@Param("id") long id){
        return productDao.select(id);
    }

    @Transactional(readOnly = false)
    public void update(Product product){
        productDao.update(product);
    }
}
