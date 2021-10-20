package com.example.xo.entity;

import lombok.Data;

/**
 * @Author: Lc
 * @Date: 2021-07-29
 */
@Data
public class UserMember {
    /*账户id*/
    private Long memberId;

    /*用户等级*/
    private Long level;

    /*用户积分*/
    private Integer integral;

}
