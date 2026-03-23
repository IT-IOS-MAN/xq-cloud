package com.share.common.autoconfigure.mvc.aspects;

import com.share.common.utils.ArrayUtils;
import com.share.common.utils.CollUtils;
import com.share.common.validate.Checker;
import com.share.common.validate.annotations.ParamChecker;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 参数校验切面
 * @date 2026/3/23 23:51
 */
@Aspect
@Slf4j
@SuppressWarnings("all")
public class CheckerAspect {

    /**
     * 方法执行前执行
     * @param joinPoint
     * @param paramChecker
     */
    @Before("@annotation(paramChecker)")
    public void before(JoinPoint joinPoint, ParamChecker paramChecker) {
        Object[] args = joinPoint.getArgs();
        if(ArrayUtils.isNotEmpty(args)){
            //遍历方法参数，参数是否实现了Checker接口
            for (Object arg : args){
                if(arg instanceof Checker) {
                    //调用check方法，校验业务逻辑
                    ((Checker)arg).check();
                }else if(arg instanceof List){
                    //如果参数是一个集合也要校验
                    CollUtils.check((List) arg);
                }
            }
        }
    }
}

