package xyz.wadewhy.springboot_redis01.base.utils;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springboot_redis01.base.utils
 * @NAME: RedisTemplate
 * @Author: 钟子豪
 * @DATE: 2020/3/25
 * @MONTH_NAME_FULL: 三月
 * @DAY: 25
 * @DAY_NAME_FULL: 星期三
 * @PROJECT_NAME: springboot_redis01
 * 实现分库存储，重写RedisTemplate,加入选库
 * 加入indexdb为Redis库的编号，重写里面的RedisConnection方法
 * 加入是否有库值传递进来的逻辑判断
 **/

public class RedisTemplate extends org.springframework.data.redis.core.RedisTemplate {
    public static ThreadLocal<Integer> indexdb = new ThreadLocal<Integer>(){
        @Override protected Integer initialValue() { return 0; }
    };

    @Override
    protected RedisConnection preProcessConnection(RedisConnection connection, boolean existingConnection) {
        try {
            Integer dbIndex = indexdb.get();
            //如果设置了dbIndex
            if (dbIndex != null) {
                if (connection instanceof JedisConnection) {
                    if (((JedisConnection) connection).getNativeConnection().getDB().intValue() != dbIndex) {
                        connection.select(dbIndex);
                    }
                } else {
                    connection.select(dbIndex);
                }
            } else {
                connection.select(0);
            }
        } finally {
            indexdb.remove();
        }
        return super.preProcessConnection(connection, existingConnection);
    }

}
