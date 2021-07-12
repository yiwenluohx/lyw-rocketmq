package com.study.shop.exception;

import com.study.shop.constant.ShopCode;


/**
 * 异常抛出类
 */
public class CastException {
    public static void cast(ShopCode shopCode) {
//        log.error(shopCode.toString());
        throw new CustomerException(shopCode);
    }
}
