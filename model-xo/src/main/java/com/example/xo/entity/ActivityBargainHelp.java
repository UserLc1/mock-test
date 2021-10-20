package com.example.xo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: Lc
 * @Date: 2021-08-10
 * @apiNote
 */
@Data
@TableName("activity_bargain_help")
public class ActivityBargainHelp {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long activityId;
    private Long memberId;
    private BigDecimal price;
    private Long userId;
    private String createTime;
}
