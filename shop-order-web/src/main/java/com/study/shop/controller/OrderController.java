package com.study.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.study.shop.api.IOrderService;
import com.study.shop.entity.Result;
import com.study.shop.pojo.TradeOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: luohx
 * @Description: 描述
 * @Date: 2021/7/12 0012 17:39
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    private IOrderService orderService;

    @RequestMapping("/confirm")
    public Result confirmOrder(@RequestBody TradeOrder order){
        return orderService.confirmOrder(order);
    }

}