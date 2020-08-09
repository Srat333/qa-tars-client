package com.tencent.tars.client.testclient.Impl;


import com.qq.tars.spring.annotation.TarsClient;
import com.qq.tars.spring.annotation.TarsServant;
import com.tencent.tars.client.testclient.QuestionServant;
import com.tencent.tars.client.testserver.QuestionPrx;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/qa")
@TarsServant("QuestionClientObj")
public class QuestionServantImpl implements QuestionServant {

  @TarsClient("Qingjiao.QuestionService.QuestionObj@tcp -h 192.168.3.6 -t 60000 -p 21000")
  QuestionPrx questionPrx;

  @Override
  @RequestMapping(value = {"/add"},method = RequestMethod.POST)
  public void addQuestion(@RequestParam("title") String qTitle,
                          @RequestParam("content") String qContent,
                          @RequestParam("category") String category,
                          @RequestParam("tag") String tag) {
    boolean result = questionPrx.addQuestion(qTitle,qContent,category,tag);
    if(result)
      log.info("add questions successfully!!!!! <3");
    else {
      log.error("add:(");
    }
  }
}
