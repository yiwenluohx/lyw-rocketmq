package com.study.shop.api;

import com.study.shop.entity.Result;
import com.study.shop.pojo.TradeUser;
import com.study.shop.pojo.TradeUserMoneyLog;

public interface IUserService {
    TradeUser findOne(Long userId);

    Result updateMoneyPaid(TradeUserMoneyLog userMoneyLog);
}
