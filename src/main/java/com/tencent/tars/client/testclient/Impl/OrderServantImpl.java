package com.tencent.tars.client.testclient.Impl;


import com.qq.tars.spring.annotation.TarsClient;
import com.qq.tars.spring.annotation.TarsServant;
import com.tencent.tars.client.exception.Result;
import com.tencent.tars.client.testserver.OrderPrx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/qa")
@TarsServant("OrderClientObj")
public class OrderServantImpl {

  @TarsClient("Qingjiao.QAService.OrderObj@tcp -h 192.168.3.6 -t 60000 -p 21002")
  private OrderPrx orderService;

  @RequestMapping(value = "/add",method = RequestMethod.POST)
  public Result addOrder(@RequestParam("qid") Long qid) {
    return orderService.addOrder(qid,"");
  }

  @RequestMapping(value = "/pay",method = RequestMethod.POST)
  public Result payOrder(@RequestParam("qid") Long qid) {
    return orderService.payOrder(qid);
  }

  @RequestMapping(value = "/refund",method = RequestMethod.POST)
  public Result refund(@RequestParam("qid") Long qid) {
    return orderService.refund(qid);
  }

  @RequestMapping(value = "/usr",method = RequestMethod.GET)
  public Result searchOrdersByQid(@RequestParam("qid") Long qid) {
    return orderService.searchOrdersByQid(qid);
  }


}
