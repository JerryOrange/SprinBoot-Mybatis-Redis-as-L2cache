package com.ncu.jerry.service;

import com.ncu.jerry.dao.ContentDao;
import com.ncu.jerry.entity.Content;
import com.ncu.jerry.jedis.JedisClientSingle;
import com.ncu.jerry.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * cache
 *
 * Created by Jiacheng on 2018/7/3.
 */
@Service
@Transactional(readOnly = true)
public class ContentService {

    @Autowired
    private ContentDao contentDao;
    @Autowired
    private JedisClientSingle jedisClient;

    /**
     * 一般第一次访问的时候先从数据库读取数据，然后将数据写入到缓存，再次访问同一内容的时候就从缓存中读取，如果缓存中没有则从数据库中读取
     * 所以我们添加缓存逻辑的时候，从数据库中将内容读取出来之后，先set入缓存，然后再从缓存中添加读取行为，如果缓存为空则从数据库中进行读取
     *
     * @param categoryId
     * @return
     */
    public List<Content> getContentList(Long categoryId) {
        //从缓存中获取值
        String getData = jedisClient.hget("CONTENTCATEGORYID", categoryId+"");
        if (!StringUtils.isBlank(getData)) {
            List<Content> resultList= JsonUtils.jsonToList(getData, Content.class);
            return resultList;
        }
        List<Content> list = contentDao.selectByCategoryId(categoryId);
        //向缓存中放入值
        String jsonData = JsonUtils.objectToJson(list);
        jedisClient.hset("CONTENTCATEGORYID", categoryId+"",jsonData);
        return list;
    }
}
