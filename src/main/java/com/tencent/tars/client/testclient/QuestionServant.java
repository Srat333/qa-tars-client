package com.tencent.tars.client.testclient;


import com.qq.tars.protocol.annotation.Servant;
import org.springframework.web.bind.annotation.*;

@Servant
public interface QuestionServant {

  void addQuestion(@RequestParam("title") String qTitle,
                          @RequestParam("content") String qContent,
                          @RequestParam("category") String category,
                          @RequestParam("tag") String tag);

}
