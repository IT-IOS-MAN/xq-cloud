package com.share.common.autoconfigure.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 操作数据库前自动填充需要更新的内容，只支持单个对象，不支持批量插入更新时的填充
 * @date 2026/3/7 16:12
 */
@Configuration
@ConditionalOnClass({MybatisPlusInterceptor.class, BaseMapper.class})
public class MybatisConfig {

    /**
     * @see MyBatisAutoFillInterceptor 通过自定义拦截器来实现自动注入creater和updater
     * @deprecated 存在任务更新数据导致updater写入0或null的问题，暂时废弃
     */
    // @Bean
    // @ConditionalOnMissingBean
    public BaseMetaObjectHandler baseMetaObjectHandler() {
        return new BaseMetaObjectHandler();
    }

    /**
     * 自定义拦截器
     * @param innerInterceptor 动态表名拦截器
     * @return 拦截器
     */
    @Bean
    @ConditionalOnMissingBean
    public MybatisPlusInterceptor mybatisPlusInterceptor(@Autowired(required = false) DynamicTableNameInnerInterceptor innerInterceptor) {
        // 1.定义插件主体，注意顺序：表名 > 多租户 > 分页 > 乐观锁 > 字段填充
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 2.表名插件
        if (innerInterceptor != null) {
            interceptor.addInnerInterceptor(innerInterceptor);
        }
        // 3.分页插件
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        paginationInnerInterceptor.setMaxLimit(200L);
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        // 4.字段填充插件
        interceptor.addInnerInterceptor(new MyBatisAutoFillInterceptor());
        return interceptor;
    }
}
