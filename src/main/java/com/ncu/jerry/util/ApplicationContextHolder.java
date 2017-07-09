package com.ncu.jerry.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/*
 *使用Spring封装的redisTemplate来操作Redis。
 *网上所有介绍redis做二级缓存的文章都是直接用jedis库，但是原博客中(www.kissyu.org)认为这样不够Spring Style；
 *而且，redisTemplate封装了底层的实现，未来如果我们不用jedis了，我们可以直接更换底层的库，而不用修改上层的代码。
 *更方便的是，使用redisTemplate，我们不用关心redis连接的释放问题，否则新手很容易忘记释放连接而导致应用卡死。
*/
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        applicationContext = ctx;
    }

    /**
     * Get application context from everywhere
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * Get bean by class
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * Get bean by class name
     *
     * @param name
     * @param <T>
     * @return
     */

    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }
}
