package com.share.common.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: id和name键值对
 * @date 2026/3/7 16:12
 */
@Data
@ApiModel(description = "id和name键值对")
@NoArgsConstructor
@AllArgsConstructor
public class IdNameDTO {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("name")
    private String name;
}
