package com.study.shop.api;

import com.study.shop.entity.Result;
import com.study.shop.pojo.TradeOrder;

public interface IOrderService {

    /**
     * 下单接口
     * @param order
     * @return
     */
    Result confirmOrder(TradeOrder order);

}
