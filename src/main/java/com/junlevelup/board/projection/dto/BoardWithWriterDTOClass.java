package com.junlevelup.board.projection.dto;

import com.junlevelup.board.entity.Board;
import com.junlevelup.board.entity.Member;
import lombok.Getter;


@Getter
public class BoardWithWriterDTOClass {
  private final Board board;
  private final Member member;

  public BoardWithWriterDTOClass(Board board, Member member) {
    this.board = board;
    this.member = member;
  }
}
