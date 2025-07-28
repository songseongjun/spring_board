package com.junlevelup.board.domain.projection.dto;

import com.junlevelup.board.domain.entity.Board;
import com.junlevelup.board.domain.entity.Member;

public record BoardWithWriterDTORecord(Board board, Member member) {

}
