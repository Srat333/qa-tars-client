package com.tencent.tars.client.testserver;


import com.qq.tars.protocol.annotation.Servant;
import com.tencent.tars.client.exception.Result;

@Servant
public interface AnswerPrx {

  Result addAnswer(Long qid, String aContent,String uid);

  Result updateAnswer(String content, Long aid);

  Result comment(String comment, Long aid, double score);

  Result deleteAnswer(Long aid);

 // Answer searchOneQuestion(Long qid);

 // Answer searchOneAnswer(Long aid);

  Result searchAnswersByUid(String uid);

}
