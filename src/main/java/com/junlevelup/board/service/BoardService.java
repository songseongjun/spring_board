package com.junlevelup.board.service;

import com.junlevelup.board.dto.BoardDTO;
import com.junlevelup.board.dto.PageRequestDTO;
import com.junlevelup.board.dto.PageResponseDTO;
import com.junlevelup.board.entity.Board;
import com.junlevelup.board.entity.Member;
import com.junlevelup.board.projection.dto.BoardWithReplyCount;


public interface BoardService {
  Long register(BoardDTO boardDTO);

  PageResponseDTO<BoardDTO, BoardWithReplyCount> getList(PageRequestDTO pageRequestDTO);

  BoardDTO get(Long bno);

  void remove(Long bno);

  void modify(BoardDTO boardDTO);

  // DML(insert,update)
  default Board toEntity(BoardDTO dto) {
    return Board.builder()
            .bno(dto.getBno())
            .title(dto.getTitle())
            .content(dto.getContent())
            .writer(Member.builder().email(dto.getWriterEmail()).build())
            .build();
  }
      //select
  default BoardDTO toDTO(Board entity, Member member, Long replyCnt) {
    return BoardDTO.builder()
            .bno(entity.getBno())
            .title(entity.getTitle())
            .content(entity.getContent())
            .regDate(entity.getRegDate())
            .modDate(entity.getModDate())
            .writerEmail(member.getEmail())
            .writerName(member.getName())
            .replyCount(replyCnt)
            .build();
  }

  default BoardDTO projectionTodTo(BoardWithReplyCount entity) {
    return BoardDTO.builder()
            .bno(entity.getBoard().getBno())
            .title(entity.getBoard().getTitle())
            .content(entity.getBoard().getContent())
            .regDate(entity.getBoard().getRegDate())
            .modDate(entity.getBoard().getModDate())
            .writerEmail(entity.getBoard().getWriter().getEmail())
            .writerName(entity.getBoard().getWriter().getName())
            .replyCount(entity.getReplyCount())
            .build();
  }

}
