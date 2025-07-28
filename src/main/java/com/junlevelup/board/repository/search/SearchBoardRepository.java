package com.junlevelup.board.repository.search;

import com.junlevelup.board.domain.entity.Board;
import com.junlevelup.board.domain.projection.dto.BoardWithReplyCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchBoardRepository extends  SearchSupport<Board>{
  Board search1();

  Page<BoardWithReplyCount> searchPage(String type, String keyword, Pageable pageable);
}
