package com.example.sharding.controller;


import com.example.sharding.entity.TOrder;
import com.example.sharding.service.TOrderService;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lucas
 * @since 2020-09-24
 */
@RestController
@RequestMapping("/v1")
@Api(value = "sharding")
public class TOrderController {

  @Resource
  private TOrderService tOrderService;

  @RequestMapping("/order")
  @ApiOperation(value = "分库分表")
  public void insert() {
    List<TOrder> tOrders = Lists.newArrayList();
    TOrder tOrder = new TOrder();
    tOrder.setUserId(2L);
    tOrder.setOrderId(2L);
    tOrder.setOrderName("lq");
    tOrder.setOrderStatus(0);
    tOrders.add(tOrder);
    TOrder tOrder1 = new TOrder();
    tOrder1.setUserId(3L);
    tOrder1.setOrderId(3L);
    tOrder1.setOrderName("dd");
    tOrder1.setOrderStatus(1);
    tOrders.add(tOrder1);
    tOrderService.saveBatch(tOrders,20);
  }

  @RequestMapping("/orderGet")
  @ApiOperation(value = "读写分离")
  public void get() {
    TOrder tOrder = new TOrder();
    tOrder.setId(3L);
    System.out.println(tOrderService.getById(tOrder));
  }
}
