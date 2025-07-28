package com.junlevelup.board.domain.projection.dto;

import com.junlevelup.board.domain.entity.Board;
import com.junlevelup.board.domain.entity.Reply;

public record BoardWithReplyDTORecord(Board board, Reply reply) {

}
