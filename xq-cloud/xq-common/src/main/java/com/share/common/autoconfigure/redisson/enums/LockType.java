package com.share.common.autoconfigure.redisson.enums;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 锁类型
 * @date 2026/3/8 1:13
 */
public enum LockType {

    /**
     * 默认锁
     */
    DEFAULT(){
        @Override
        public RLock getLock(RedissonClient redissonClient, String name) {
            return redissonClient.getLock(name);
        }
    },

    /**
     * 公平锁
     */
    FAIR_LOCK(){
        @Override
        public RLock getLock(RedissonClient redissonClient, String name) {
            return redissonClient.getFairLock(name);
        }
    },

    /**
     * 读锁
     */
    READ_LOCK(){
        @Override
        public RLock getLock(RedissonClient redissonClient, String name) {
            return redissonClient.getReadWriteLock(name).readLock();
        }
    },

    /**
     * 写锁
     */
    WRITE_LOCK(){
        @Override
        public RLock getLock(RedissonClient redissonClient, String name) {
            return redissonClient.getReadWriteLock(name).writeLock();
        }
    },
    ;

    /**
     * 获取锁
     * @param redissonClient redisson客户端
     * @param name 锁名称
     * @return 锁对象
     */
    public abstract RLock getLock(RedissonClient redissonClient, String name);
}
