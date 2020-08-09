package com.tencent.tars.client.testserver;

import com.qq.tars.protocol.annotation.Servant;

@Servant
public interface QuestionPrx {

  boolean addQuestion(String q_title,String q_content, String category,String tag);
}
