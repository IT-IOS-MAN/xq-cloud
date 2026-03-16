package com.share.common.validate;

import com.share.common.enums.BaseEnum;
import com.share.common.utils.ArrayUtils;
import com.share.common.validate.annotations.EnumValid;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 枚举校验器校验逻辑
 * @date 2026/3/7 16:12
 */
@Slf4j
public class EnumValidator implements ConstraintValidator<EnumValid, BaseEnum> {

    private int[] enums = null;

    /**
     * 初始化校验器
     * @param enumValid 枚举校验注解
     */
    @Override
    public void initialize(EnumValid enumValid) {
        this.enums = enumValid.enumeration();
        log.info("payload>>{}", ArrayUtils.toString(enumValid.payload()));
    }

    /**
     * 校验逻辑
     * @param em 枚举值
     * @param context 校验上下文
     * @return 校验结果
     */
    @Override
    public boolean isValid(BaseEnum em, ConstraintValidatorContext context) {
        // 不做空校验
        if(em == null){
            return true;
        }
        //没有配置枚举值不校验
        if (ArrayUtils.isEmpty(enums)) {
            return true;
        }
        for (int e : enums) {
            if (e == em.getValue()) {
                return true;
            }
        }
        return false;
    }
}
