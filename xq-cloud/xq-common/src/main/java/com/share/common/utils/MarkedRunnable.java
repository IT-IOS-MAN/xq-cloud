package com.share.common.utils;

import org.slf4j.MDC;

import java.util.Map;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/7 16:12
 */
public class MarkedRunnable implements Runnable{
    private Runnable runnable;
    private Map<String, String> context;
    public MarkedRunnable(Runnable runnable) {
        this.runnable = runnable;
        this.context = MDC.getCopyOfContextMap();
    }

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
