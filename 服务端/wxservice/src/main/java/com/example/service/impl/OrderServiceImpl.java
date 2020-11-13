package com.example.service.impl;

import com.example.constant.CommonConstant;
import com.example.mapper.OrderDetailMapper;
import com.example.pojo.OrderDetail;
import com.example.pojo.OrderDetailExample;
import com.example.pojo.ResultMap;
import com.example.service.OrderService;
import com.example.utils.CommonUtils;
import com.example.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailMapper orderMapper;


    @Override
    public ResultMap create(OrderVO orderVO) {
        OrderDetail order=new OrderDetail();
        order.setOrderid(CommonUtils.generateId());
        order.setUserid(orderVO.getUserId());
        order.setContent(orderVO.getContent());
        order.setDate(new Date());
        order.setTotal(orderVO.getTotal());
        order.setState(0);
        orderMapper.insert(order);
        return new ResultMap(CommonConstant.SUCCESS,CommonConstant.RESULT_SUCCESS);
    }


    @Override
    public List<OrderDetail> getOrder(String userId) {
        OrderDetailExample orderExample=new OrderDetailExample();
        OrderDetailExample.Criteria criteria=orderExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        orderExample.setOrderByClause("`date` DESC");
        List<OrderDetail> orders=orderMapper.selectByExample(orderExample);
        return orders;
    }
}
