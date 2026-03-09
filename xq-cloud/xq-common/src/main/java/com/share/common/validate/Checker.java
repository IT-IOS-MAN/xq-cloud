package com.share.common.validate;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 实现后在接口访问时如果接口实现了这个接口
 *               会被自动自行接口check进行校验
 * @date 2026/3/7 16:12
 */

public interface Checker<T> {

    /**
     * 用于实现validation不能校验的数据逻辑
     */
    default void check(){

    }

    default void check(T data){
    }
}
