package com.junlevelup.board.repository;


import com.junlevelup.board.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTest {
  @Autowired
  private MemberRepository repository;

  @Test
  public  void testExit(){
    Assertions.assertNotNull(repository);
  }

  @Test
  public void insertMembers(){
    IntStream.range(1,100).forEach(i ->{
      Member member = Member.builder()
              .email("user" + i + "@gmail.com")
              .password("1111")
              .name("USER" + i)
              .build();
      repository.save(member);
    });
  }
}
