package com.tencent.tars.client.testclient.Impl;


import com.qq.tars.spring.annotation.TarsServant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/qa")
@TarsServant("OrderClientObj")
public class OrderServantImpl {
}
