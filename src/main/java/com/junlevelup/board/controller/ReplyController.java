package com.junlevelup.board.controller;


import com.junlevelup.board.domain.dto.ReplyDTO;
import com.junlevelup.board.domain.entity.Reply;
import com.junlevelup.board.repository.ReplyRepository;
import com.junlevelup.board.service.ReplyService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RestController
@RequestMapping("replies")
@RequiredArgsConstructor   //이건final유일한생성자를생성하기위해
public class ReplyController {
      //애가 유일하게 생성자가됨 이건Been으로 관리하기위해
  private final ReplyService replyService;

  @GetMapping( "board/{bno}")
  public ResponseEntity<?> getList(@PathVariable("bno") Long bno){
    return ResponseEntity.ok(replyService.getList(bno));
  }
  @PostMapping("")
  public ResponseEntity<Long> createReply(@RequestBody ReplyDTO dto){
    log.info(dto);
    return ResponseEntity.ok(replyService.register(dto));
  }
  @DeleteMapping("board/{rno}")
  public ResponseEntity<?> remove(@PathVariable("rno") Long rno) {
    replyService.remove(rno);
    return ResponseEntity.ok("");
  }
}

