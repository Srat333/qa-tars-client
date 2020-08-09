package com.tencent.tars.client.testclient;


import com.qq.tars.protocol.annotation.Servant;
import com.tencent.tars.client.exception.Result;
import org.springframework.web.bind.annotation.*;

@Servant
public interface QuestionServant {

  Result addQuestion(@RequestParam("title") String qTitle,
                     @RequestParam("content") String qContent,
                     @RequestParam("category") String category,
                     @RequestParam("tag") String tag,
                     @RequestParam("uid") String uid);

  Result updateQuestion(@RequestParam("title") String qTitle,
                        @RequestParam("content") String qContent,
                        @RequestParam("qid") Long qid);

  Result searchQuestions(@RequestParam("keyword") String keyword);

  Result deleteQuestion(@RequestParam("qid") Long qid);

  Result listAllQuestions();

  Result searchQuestionsByUid(@RequestParam("uid") String uid);

  Result searchAuditsByQid(@RequestParam("qid") Long qid);

  Result updateAuditsByQid(@RequestParam("qid") Long qid,
                           @RequestParam("uid") String uid);


}
