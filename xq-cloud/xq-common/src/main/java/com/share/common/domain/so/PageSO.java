package com.share.common.domain.so;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.share.common.constants.Constant;
import com.share.common.utils.StringUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 分页请求参数
 * @date 2026/3/7 16:12
 */
@Data
@ApiModel(description = "分页请求参数")
@Accessors(chain = true)
public class PageSO<Condition> {
    public static final Integer DEFAULT_PAGE_SIZE = 20;
    public static final Integer DEFAULT_PAGE_NUM = 1;

    @ApiModelProperty(value = "页码", example = "1")
    @Min(value = 1, message = "页码不能小于1")
    private Integer pageNo = DEFAULT_PAGE_NUM;

    @ApiModelProperty(value = "每页大小", example = "5")
    @Min(value = 1, message = "每页查询数量不能小于1")
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    @ApiModelProperty(value = "条件", required=true)
    private Condition condition;

    @ApiModelProperty(value = "是否升序", example = "true")
    private Boolean isAsc = true;

    @ApiModelProperty(value = "排序字段", example = "id")
    private String sortBy;

    /**
     * 获取分页起始位置
     * @return 起始位置
     */
    public int from(){
        return (pageNo - 1) * pageSize;
    }

    /**
     * 转换为mybatis-plus分页对象
     * @param orderItems 排序字段
     * @param <T> 泛型
     * @return 分页对象
     */
    public <T> Page<T> toMpPage(OrderItem... orderItems) {
        Page<T> page = new Page<>(pageNo, pageSize);
        // 是否手动指定排序方式
        if (orderItems != null && orderItems.length > 0) {
            for (OrderItem orderItem : orderItems) {
                page.addOrder(orderItem);
            }
            return page;
        }
        // 前端是否有排序字段
        if (StringUtils.isNotEmpty(sortBy)){
            OrderItem orderItem = new OrderItem();
            orderItem.setAsc(isAsc);
            orderItem.setColumn(sortBy);
            page.addOrder(orderItem);
        }
        return page;
    }

    /**
     * 转换为mybatis-plus分页对象
     * @param defaultSortBy 默认排序字段
     * @param isAsc 是否升序
     * @param <T> 泛型
     * @return 分页对象
     */
    public <T> Page<T> toMpPage(String defaultSortBy, boolean isAsc) {
        if (StringUtils.isBlank(sortBy)){
            sortBy = defaultSortBy;
            this.isAsc = isAsc;
        }
        Page<T> page = new Page<>(pageNo, pageSize);
        OrderItem orderItem = new OrderItem();
        orderItem.setAsc(this.isAsc);
        orderItem.setColumn(sortBy);
        page.addOrder(orderItem);
        return page;
    }

    /**
     * 转换为mybatis-plus分页对象
     * @param <T> 泛型
     * @return 分页对象
     */
    public <T> Page<T> toMpPageDefaultSortByCreateTimeDesc() {
        return toMpPage(Constant.DATA_FIELD_NAME_CREATE_TIME, false);
    }
}