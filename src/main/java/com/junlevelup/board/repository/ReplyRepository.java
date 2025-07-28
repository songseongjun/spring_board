package com.junlevelup.board.repository;

import com.junlevelup.board.domain.entity.Board;
import com.junlevelup.board.domain.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
  void deleteByBoard_Bno(long bno);

  List<Reply> findByBoard_Bno(long bno);

  List<Reply> findByBoard_BnoOrderByRno(long bno);
  List<Reply> findByBoard(Board board);

  Long rno(Long rno);
}
