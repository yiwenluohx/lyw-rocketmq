package com.study.shop.api;

import com.study.shop.entity.Result;
import com.study.shop.pojo.TradeOrder;

/**
 * @Author: luohx
 * @Description: 添加订单服务接口
 * @Date: 2021/7/12 9:45
 */
public interface IOrderService {
    /**
     * 下单接口
     *
     * @param order
     * @return
     */
    Result confirmOrder(TradeOrder order);
}
