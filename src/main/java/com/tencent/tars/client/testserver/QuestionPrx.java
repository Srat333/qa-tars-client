package com.tencent.tars.client.testserver;

import com.qq.tars.protocol.annotation.Servant;
import com.tencent.tars.client.exception.Result;

@Servant
public interface QuestionPrx {

  Result addQuestion(String qContent, String tag, String qTitle, String category,String uid);

  Result updateQuestion(String qContent, Long qid, String qTitle);

  Result deleteQuestion(Long qid);

  Result searchQuestions(String keyword);

  Result searchOneQuestion(Long qid);

  Result listAllQuestions();

  Result searchQuestionsByUid(String uid);

  Result searchAuditsByQid(Long qid);

  Result updateAuditsByQid(Long qid, String uid);
}
