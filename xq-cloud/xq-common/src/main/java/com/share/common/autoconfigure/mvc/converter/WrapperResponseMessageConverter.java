package com.share.common.autoconfigure.mvc.converter;

import com.share.common.utils.WebUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 包装响应消息转换器
 * @date 2026/3/23 23:51
 */
public class WrapperResponseMessageConverter implements HttpMessageConverter<Object> {

    /**
     * 委托转换器
     */
    private final MappingJackson2HttpMessageConverter delegate;

    /**
     * 构造函数
     * @param mappingJackson2HttpMessageConverter
     */
    public WrapperResponseMessageConverter(
            MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter) {
        this.delegate = mappingJackson2HttpMessageConverter;
    }

    /**
     * 是否可以读取
     * @param clazz
     * @param mediaType
     * @return
     */
    @Override
    public boolean canRead(@NonNull Class<?> clazz, MediaType mediaType) {
        return false;
    }

    /**
     * 是否可以写入
     * @param clazz
     * @param mediaType
     * @return
     */
    @Override
    public boolean canWrite(@NonNull Class<?> clazz, MediaType mediaType) {
        return WebUtils.isGatewayRequest() && delegate.canWrite(clazz, mediaType);
    }

    /**
     * 获取支持的媒体类型
     * @return
     */
    @Override
    @NonNull
    public List<MediaType> getSupportedMediaTypes() {
        return delegate.getSupportedMediaTypes();
    }

    /**
     * 读取
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    @NonNull
    public Object read(@NonNull Class<?> clazz,@NonNull HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return delegate.read(clazz, inputMessage);
    }

    /**
     * 写入
     * @param o
     * @param contentType
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    public void write(@NonNull Object o, MediaType contentType,@NonNull HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        delegate.write(o, contentType, outputMessage);
    }
}

