package com.junlevelup.board.repository;


import com.junlevelup.board.entity.Board;
import com.junlevelup.board.entity.Reply;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Log4j2
@SpringBootTest
public class ReplyRepositoryTest {
  @Autowired
  private ReplyRepository repository;
@Autowired
private BoardRepository boardRepository;

  @Test
  public  void testExit(){
    Assertions.assertNotNull(repository);
  }

  @Test
  public void insertReply(){
  List<Long> bnos = boardRepository.findAll().stream().map(Board::getBno).toList();
    IntStream.rangeClosed(1,300).forEach(i -> {
      long bno = bnos.get(new Random().nextInt(bnos.size()));
      Board board =Board.builder().bno(bno).build();
      Reply reply = Reply.builder()
              .board(board)
              .text("reply"+ i)
              .replyer("guest")
              .build();

      repository.save(reply);
    });
  }

  @Test
  public  void  testRead(){
    Reply reply = repository.findById(1L).orElse(null);
    log.info(reply);
    log.info(reply.getBoard());
    log.info(reply.getBoard().getWriter());
  }
}
