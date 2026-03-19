package com.share.auth.domain.po;

import cn.xbatis.db.annotations.Table;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 账户、角色关联表
 * @date 2026/3/7 16:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table
@TableName("account_role")
public class AccountRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 角色id
     */
    private Long roleId;

}