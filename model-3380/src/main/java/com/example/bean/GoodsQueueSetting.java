package com.example.bean;

import lombok.Data;

/**
 * @author 王斌伟
 * @date 2022/2/21 10:18
 * @description
 */

@Data
public class GoodsQueueSetting extends SuperTestSetting{

    /**
     * 间隔内下单最小值
     */
    private Integer numbMin;
    /**
     * 间隔内下单最大值
     */
    private Integer numbMax;

    /**
     * 虚拟用户要下单的总数
     */
    private Integer orderSum;

    /**
     * 虚拟用户下单阈值
     */
    private Integer ratio;

    /**
     * 间隔时间
     */
    private Integer intervalTime;

    /**
     * 商品总库存
     */
    private Integer stock;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 限购规则
     */
    private String limits;

    /**
     * 表示本次任务还需下单的数量
     */
    private Integer actualSurplusCount;

    /**
     * 本次任务生成的随机数
     */
    private Integer random;

}
