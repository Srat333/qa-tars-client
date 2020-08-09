package com.tencent.tars.client.testclient.Impl;


import com.qq.tars.spring.annotation.TarsClient;
import com.qq.tars.spring.annotation.TarsServant;
import com.tencent.tars.client.exception.Result;
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

  @TarsClient("Qingjiao.QAService.QuestionObj@tcp -h 192.168.3.6 -t 60000 -p 21000")
  QuestionPrx questionService;


  @RequestMapping(value={"/add"},method = RequestMethod.POST)
  public Result addQuestion(@RequestParam("title") String qTitle,
                            @RequestParam("content") String qContent,
                            @RequestParam("category") String category,
                            @RequestParam("tag") String tag,
                            @RequestParam("uid") String uid) {
    return questionService.addQuestion(qContent,tag,qTitle,category,uid);
  }


  @RequestMapping(value={"/update"},method = RequestMethod.POST)
  public Result updateQuestion(@RequestParam("title") String qTitle,
                               @RequestParam("content") String qContent,
                               @RequestParam("qid") Long qid) {
    return questionService.updateQuestion(qContent,qid,qTitle);
  }

  @RequestMapping(value={"/search"},method = RequestMethod.GET)
  public Result searchQuestions(@RequestParam("keyword") String keyword) {
    return questionService.searchQuestions(keyword);
  }

  @RequestMapping(value={"/delete"},method = RequestMethod.DELETE)
  public Result deleteQuestion(@RequestParam("qid") Long qid) {
    return questionService.deleteQuestion(qid);
  }

  @RequestMapping(value={"/all"},method = RequestMethod.GET)
  public Result listAllQuestions() {
    Result result = questionService.listAllQuestions();
    if(result!=null) {
      log.info("list all successfully!!!!");
      return result;
    } else {
      log.error("list add :(");
      return null;
    }
  }

  @RequestMapping(value={"/user_q"},method = RequestMethod.GET)
  public Result searchQuestionsByUid(@RequestParam("uid") String uid) {
    return questionService.searchQuestionsByUid(uid);
  }


//  @RequestMapping(value = {"/upload"}, method = RequestMethod.POST)
//  public void upload(@RequestParam("file") MultipartFile file) {
//    String localPath = "/src/main/resources/images/upload";
//    if(FileUtils.upload(file, localPath,file.getOriginalFilename())) {
//      log.info("upload succ :)");
//    } else {
//      log.error("upload failed :(");
//    }
//  }

  @RequestMapping(value = {"/searchAudits"},method = RequestMethod.POST)
  public Result searchAuditsByQid(@RequestParam("qid") Long qid) {
    return questionService.searchAuditsByQid(qid);
  }

  @RequestMapping(value = {"/updateAudits"},method = RequestMethod.POST)
  public Result updateAuditsByQid(@RequestParam("qid") Long qid,
                                  @RequestParam("uid") String uid) {
    return questionService.updateAuditsByQid(qid,uid);
  }
}
