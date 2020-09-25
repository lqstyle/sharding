package com.example.sharding;


import com.example.sharding.entity.TOrder;
import com.example.sharding.service.TOrderService;
import java.util.List;
import javax.annotation.Resource;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShardingApplicationTest {

  @Resource
  private TOrderService tOrderService;

  @Test
  public void test() {
    List<TOrder> tOrders = Lists.newArrayList();
    TOrder tOrder = new TOrder();
    tOrder.setUserId(1L);
    tOrder.setOrderId(1L);
    tOrder.setOrderName("lq");
    tOrder.setOrderStatus(0);
    tOrders.add(tOrder);
    TOrder tOrder1 = new TOrder();
    tOrder1.setUserId(2l);
    tOrder1.setOrderId(2L);
    tOrder1.setOrderName("dd");
    tOrder1.setOrderStatus(1);
    tOrders.add(tOrder1);
    tOrderService.saveBatch(tOrders);
  }

}
