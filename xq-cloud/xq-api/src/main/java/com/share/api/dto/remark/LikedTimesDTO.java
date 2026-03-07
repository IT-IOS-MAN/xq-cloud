package com.share.api.dto.remark;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/8 1:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class LikedTimesDTO {
    private Long bizId;
    private Integer likedTimes;
}
