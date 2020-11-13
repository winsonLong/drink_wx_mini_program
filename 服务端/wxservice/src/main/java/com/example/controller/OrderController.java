package com.example.controller;


import com.example.constant.CommonConstant;
import com.example.pojo.OrderDetail;
import com.example.pojo.ResultMap;
import com.example.service.OrderService;
import com.example.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/order"})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("getOrders")
    public ResultMap getOrders(@RequestParam("userId") String userId) {
        List<OrderDetail> orders=orderService.getOrder(userId);
        return new ResultMap(CommonConstant.SUCCESS,CommonConstant.RESULT_SUCCESS,orders);
    }


    @PostMapping("create")
    public ResultMap create(@RequestBody OrderVO orderVO) {
        return orderService.create(orderVO);
    }
}

