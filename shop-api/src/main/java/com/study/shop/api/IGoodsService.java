package com.study.shop.api;

import com.study.shop.entity.Result;
import com.study.shop.pojo.TradeGoods;
import com.study.shop.pojo.TradeGoodsNumberLog;

public interface IGoodsService {
    /**
     * 根据ID查询商品对象
     * @param goodsId
     * @return
     */
    TradeGoods findOne(Long goodsId);

    /**
     * 扣减库存
     * @param goodsNumberLog
     * @return
     */
    Result reduceGoodsNum(TradeGoodsNumberLog goodsNumberLog);
}
