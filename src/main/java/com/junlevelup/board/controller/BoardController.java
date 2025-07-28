package com.junlevelup.board.controller;

import com.junlevelup.board.domain.dto.BoardDTO;
import com.junlevelup.board.domain.dto.PageRequestDTO;
import com.junlevelup.board.service.BoardService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board")
@Log4j2
@Data
public class BoardController {
  private final BoardService service;

  // 등록 폼
  @GetMapping("register")
  public void register() {}



  // 등록 프로세스
  @PostMapping("register")
  public String register(BoardDTO dto , RedirectAttributes rttr) {
    rttr.addFlashAttribute("msg", service.register(dto));
    return "redirect:list";
  }


  // 목록 조회
  @GetMapping("list")
  public void list(@ModelAttribute("requestDto") PageRequestDTO dto, Model model) {
    if(dto.getType() == null) dto.setType(""); // 기본값
    if(dto.getKeyword() == null) dto.setKeyword(""); // 기본값
    model.addAttribute("dto", service.getList(dto));
    model.addAttribute("requestDto", dto);
  }

  @GetMapping("read")
  public void read(@ModelAttribute("requestDto") PageRequestDTO dto, Model model, Long bno) {
    model.addAttribute("dto", service.get(bno));

//    model.addAttribute("pageDto", dto);
  }


  @GetMapping("modify")
  public void modify(@ModelAttribute("requestDto") PageRequestDTO dto, Model model, Long bno) {
    model.addAttribute("dto", service.get(bno));
  }

  @PostMapping("modify")
  public String modify(@ModelAttribute("requestDto") PageRequestDTO dto,BoardDTO boardDTO, RedirectAttributes rttr) {

    service.modify(boardDTO);
    rttr.addAttribute("bno", boardDTO.getBno());
    rttr.addAttribute("page", dto.getPage());
    rttr.addAttribute("size", dto.getSize());
    rttr.addAttribute("type", dto.getType());
    rttr.addAttribute("keyword", dto.getKeyword());
    return  "redirect:read";
  }

  @PostMapping("remove")
  public  String remove(PageRequestDTO dto, Long bno, RedirectAttributes rttr) {
    service.remove(bno);
    rttr.addFlashAttribute("msg",bno);
    rttr.addAttribute("page", 1);
    rttr.addAttribute("size", dto.getSize());
    return "redirect:list";
  }

}
