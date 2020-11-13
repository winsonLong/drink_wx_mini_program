package com.example.service;

import com.example.pojo.OrderDetail;
import com.example.pojo.ResultMap;
import com.example.vo.OrderVO;

import java.util.List;

public interface OrderService {

    ResultMap create(OrderVO orderVO);

    List<OrderDetail> getOrder(String userId);
}
