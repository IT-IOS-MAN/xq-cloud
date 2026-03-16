package com.share.common.utils;

import org.slf4j.MDC;

import java.util.Map;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: MDC 工具类
 * @date 2026/3/7 16:12
 */
public class MarkedRunnable implements Runnable{

    /**
     * 被包装的Runnable
     */
    private Runnable runnable;

    /**
     * MDC 上下文
     */
    private Map<String, String> context;

    /**
     * 构造方法
     * @param runnable 被包装的Runnable
     */
    public MarkedRunnable(Runnable runnable) {
        this.runnable = runnable;
        this.context = MDC.getCopyOfContextMap();
    }

    /**
     * 执行方法
     */
    @Override
    public void run() {
        if(context == null){
            MDC.clear();
        }else {
            MDC.setContextMap(context);
        }
        try {
            runnable.run();
        }finally {
            MDC.clear();
        }
    }
}
