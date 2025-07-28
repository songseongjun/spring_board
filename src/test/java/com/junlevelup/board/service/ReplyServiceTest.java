package com.junlevelup.board.service;


import com.junlevelup.board.domain.dto.ReplyDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class ReplyServiceTest {
  @Autowired
  private ReplyService replyService;
  @Test
  public void testExist(){
    log.info(replyService);
  }

  @Test
  public void  testRegister(){
    replyService.register(ReplyDTO.builder().bno(7L).text("댓글테스트").replyer("모").build());

  }

  @Test
  public  void testList(){
  replyService.getList(7L).forEach(log::info);
  }


  @Test
  public void testModify(){
    ReplyDTO replyDTO = replyService.get(7L) ;
    replyDTO.setText("내용변경");
    replyService.modify(replyDTO);
//    replyDTO.setRno(100L);
    log.error(replyService.get(601L));
  }

  @Test
  public void testGet(){
    try{
      replyService.get(1000L);

    }
    catch (IllegalArgumentException e){
      log.error(e.getMessage());
    }
  }
  @Test
  public void testRemove(){
    replyService.remove(100L);
  }
}
