package com.tencent.tars.client.testserver;


import com.qq.tars.protocol.annotation.Servant;
import com.tencent.tars.client.exception.Result;

@Servant
public interface OrderPrx {

  Result addOrder(Long qid,String url);

  Result payOrder(Long qid);

  Result refund(Long qid);

  Result searchOrdersByQid(Long qid);

}
