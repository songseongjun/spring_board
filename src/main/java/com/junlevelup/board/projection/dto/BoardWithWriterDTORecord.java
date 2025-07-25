package com.junlevelup.board.projection.dto;

import com.junlevelup.board.entity.Board;
import com.junlevelup.board.entity.Member;

public record BoardWithWriterDTORecord(Board board, Member member) {

}
