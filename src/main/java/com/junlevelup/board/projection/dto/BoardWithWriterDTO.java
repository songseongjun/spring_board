package com.junlevelup.board.projection.dto;

import com.junlevelup.board.entity.Board;
import com.junlevelup.board.entity.Member;

public interface BoardWithWriterDTO {
  Board getBoard();
  Member getMember();
}
