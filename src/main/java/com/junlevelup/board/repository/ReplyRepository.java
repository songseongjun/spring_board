package com.junlevelup.board.repository;

import com.junlevelup.board.entity.Board;
import com.junlevelup.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
  void deleteByBoard_Bno(long bno);
}
