package com.junlevelup.board.domain.projection.dto;

import com.junlevelup.board.domain.entity.Board;
import com.junlevelup.board.domain.entity.Member;

public interface BoardWithWriterDTO {
  Board getBoard();
  Member getMember();
}
