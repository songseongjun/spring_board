package com.junlevelup.board.service;

import com.junlevelup.board.domain.dto.BoardDTO;
import com.junlevelup.board.domain.dto.PageRequestDTO;
import com.junlevelup.board.domain.dto.PageResponseDTO;
import com.junlevelup.board.domain.dto.ReplyDTO;
import com.junlevelup.board.domain.entity.Board;
import com.junlevelup.board.domain.entity.Member;
import com.junlevelup.board.domain.entity.Reply;
import com.junlevelup.board.domain.projection.dto.BoardWithReplyCount;

import java.util.List;

public interface ReplyService {
  Long register(ReplyDTO dto);

  List<ReplyDTO> getList(Long bno);

  void modify(ReplyDTO dto);

  void remove(Long rno);

  ReplyDTO get(Long rno);


}
