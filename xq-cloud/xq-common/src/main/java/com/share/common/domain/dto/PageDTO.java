package com.share.common.domain.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.share.common.utils.BeanUtils;
import com.share.common.utils.CollUtils;
import com.share.common.utils.Convert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 分页结果
 * @date 2026/3/7 16:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "分页结果")
public class PageDTO<T> {
    @ApiModelProperty("总条数")
    protected Long total;
    @ApiModelProperty("总页码数")
    protected Long pages;
    @ApiModelProperty("当前页数据")
    protected List<T> list;

    /**
     * 空分页
     * @param total 总条数
     * @param pages 总页码数
     * @param <T> 泛型
     * @return 空分页
     */
    public static <T> PageDTO<T> empty(Long total, Long pages) {
        return new PageDTO<>(total, pages, CollUtils.emptyList());
    }

    /**
     * 空分页
     * @param page 分页对象
     * @param <T> 泛型
     * @return 空分页
     */
    public static <T> PageDTO<T> empty(Page<?> page) {
        return new PageDTO<>(page.getTotal(), page.getPages(), CollUtils.emptyList());
    }

    /**
     * 转换为分页结果
     * @param page 分页对象
     * @param <T> 泛型
     * @return 分页结果
     */
    public static <T> PageDTO<T> of(Page<T> page) {
        if(page == null){
            return new PageDTO<>();
        }
        if (CollUtils.isEmpty(page.getRecords())) {
            return empty(page);
        }
        return new PageDTO<>(page.getTotal(), page.getPages(), page.getRecords());
    }

    /**
     * 转换为分页结果
     * @param page 分页对象
     * @param mapper 转换函数
     * @param <T> 泛型
     * @param <R> 泛型
     * @return 分页结果
     */
    public static <T,R> PageDTO<T> of(Page<R> page, Function<R, T> mapper) {
        if(page == null){
            return new PageDTO<>();
        }
        if (CollUtils.isEmpty(page.getRecords())) {
            return empty(page);
        }
        return new PageDTO<>(page.getTotal(), page.getPages(),
                page.getRecords().stream().map(mapper).collect(Collectors.toList()));
    }

    /**
     * 转换为分页结果
     * @param page 分页对象
     * @param list 数据列表
     * @param <T> 泛型
     * @return 分页结果
     */
    public static <T> PageDTO<T> of(Page<?> page, List<T> list) {
        return new PageDTO<>(page.getTotal(), page.getPages(), list);
    }

    /**
     * 转换为分页结果
     * @param page 分页对象
     * @param clazz 目标类型
     * @param <T> 泛型
     * @param <R> 泛型
     * @return 分页结果
     */
    public static <T, R> PageDTO<T> of(Page<R> page, Class<T> clazz) {
        return new PageDTO<>(page.getTotal(), page.getPages(), BeanUtils.copyList(page.getRecords(), clazz));
    }

    /**
     * 转换为分页结果
     * @param page 分页对象
     * @param clazz 目标类型
     * @param convert 转换器
     * @param <T> 泛型
     * @param <R> 泛型
     * @return 分页结果
     */
    public static <T, R> PageDTO<T> of(Page<R> page, Class<T> clazz, Convert<R, T> convert) {
        return new PageDTO<>(page.getTotal(), page.getPages(), BeanUtils.copyList(page.getRecords(), clazz, convert));
    }

    /**
     * 是否为空分页
     * @return 是否为空分页
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    public boolean isEmpty(){
        return list == null || list.size() == 0;
    }
}
