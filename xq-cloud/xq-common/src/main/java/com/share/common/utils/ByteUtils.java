package com.share.common.utils;

import cn.hutool.core.util.ByteUtil;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/7 16:12
 */
public class ByteUtils extends ByteUtil {

    /**
     * 将byte[] 数组转换成字符串,如果为空返回 ""
     * @param content 字节内容
     * @return 字符串值
     */
    public static String parse(byte[] content){
        if(content == null || content.length <= 0) {
            return StringUtils.EMPTY;
        }
        return new String(content);
    }
}
