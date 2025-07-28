package com.junlevelup.board.repository;


import com.junlevelup.board.domain.projection.dto.*;
import com.junlevelup.board.domain.entity.Board;
import com.junlevelup.board.domain.entity.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

@Log4j2
@SpringBootTest
public class BoardRepositoryTest {
  @Autowired
  private BoardRepository repository;
  @Autowired
  private BoardRepository boardRepository;

  @Test
  public void testExit() {
    Assertions.assertNotNull(repository);
  }

  @Test
  public void insertBoards() {
    IntStream.range(1, 100).forEach(i -> {
      Member member = Member.builder().email("user" + i + "@gmail.com").build();
      Board board = Board.builder()
              .title("title" + i)
              .content("content" + i)
              .writer(member)
              .build();
      repository.save(board);
    });
  }

  @Test
  @Transactional(readOnly = true)
  public void testRead() {
    Board board = repository.findById(1L).orElse(null);
    log.info(board);
    log.info(board.getWriter());
  }

  @Test
  public void testReadWithWriter() {
//    Arrays.stream((Object[])repository.getBoardWithWriter(1L)).forEach(log::info);
    BoardWithWriterDTO dto = repository.getBoardWithWriter(1L);
    log.info(dto.getBoard());
    log.info(dto.getMember());
  }

  @Test
  public void testReadWithWriter2() {
//    Arrays.stream((Object[])repository.getBoardWithWriter(1L)).forEach(log::info);
    BoardWithWriterDTORecord dto = repository.getBoardWithWriter2(1L);
    log.info(dto.board());
    log.info(dto.member());

  }

  @Test
  public void testReadWithWriter3() {
//    Arrays.stream((Object[])repository.getBoardWithWriter(1L)).forEach(log::info);
    BoardWithWriterDTOClass dto = repository.getBoardWithWriter3(1L);
    log.info(dto.getBoard());
    log.info(dto.getMember());
  }

  @Test
  public void testReadWithReply() {
    List<Object[]> list = repository.getBoardWithReply(1L);
    list.stream().forEach(o -> log.info("{},{}", o[0],o[1]));
    }

    @Test
  public void  testBoardWithReply() {
    List<BoardWithReplyDTORecord> list = repository.getBoardWithReply2(4L);
    list.stream().forEach(log::info);
    }

    @Test
  public void  testGetBoardWithReplyCount() {
      Page<BoardWithReplyCount> result = repository.getBoardWithReplyCount(PageRequest.of(0, 10,Sort.by(Sort.Direction.DESC,"bno")));
      result.getContent().stream().forEach(row -> log.info("{}",row));
    }

    @Test
  public void testSearch1(){
    repository.search1();
    }

    @Test
  public void testSearchPage(){
   Page<BoardWithReplyCount> bwrc = repository.searchPage("tcw","title",PageRequest.of(2, 5,
            Sort.by(Sort.Direction.DESC,"bno").and(Sort.by(Sort.Direction.ASC,"title"))));

  log.info(bwrc.getTotalPages());
  log.info(bwrc.getTotalElements());
  bwrc.getContent().forEach(log::info);
    }
  }
