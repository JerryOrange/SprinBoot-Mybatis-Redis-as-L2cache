package com.ncu.jerry.jedis;

import java.util.Map;

/**
 * JedisClient interface
 *
 * Created by Jiacheng on 2018/7/3.
 */
public interface JedisClient {

    String set(final String key, String value);

    String set(final byte[] key, final byte[] value);

    String get(final String key);

    byte[] get(final byte[] key);

    Long del(String key);

    Long del(final byte[] key);

    Long del(final String... keys);

    Long del(final byte[]... keys);

    Boolean exists(final String key);

    Long expire(final String key, final int seconds);

    Long expire(final byte[] key, final int seconds);

    Long ttl(final String key);

    Long incr(final String key);

    Long hset(final String key, final String field, final String value);

    String hget(final String key, final String field);

    Map<String, String> hgetAll(final String key);

    Long hdel(final String key, final String... field);
}
