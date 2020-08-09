package com.tencent.tars.client.testclient;


import com.qq.tars.protocol.annotation.Servant;
import com.tencent.tars.client.exception.Result;
import org.springframework.web.bind.annotation.RequestParam;

@Servant
public interface OrderServant {

  Result addOrder(@RequestParam("qid") Long qid);

  Result payOrder(@RequestParam("qid") Long qid);

  Result refund(@RequestParam("qid") Long qid);

  Result searchOrdersByQid(@RequestParam("qid") Long qid);

}
