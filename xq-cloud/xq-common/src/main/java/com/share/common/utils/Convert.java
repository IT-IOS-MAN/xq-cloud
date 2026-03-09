package com.share.common.utils;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 对原对象进行计算，设置到目标对象中
 * @date 2026/3/7 16:12
 */
public interface Convert<R,T>{
    void convert(R origin, T target);
}