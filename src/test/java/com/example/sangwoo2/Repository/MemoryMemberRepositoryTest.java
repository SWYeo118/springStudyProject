package com.example.sangwoo2.Repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.sangwoo2.Domain.Member;

import java.util.Optional;

class MemoryMemberRepositoryTest {
  
  MemoryMemberRepository repository = new MemoryMemberRepository();
  
  @Test
  public void save() {
    Member member = new Member();
    member.setName("spring");
    repository.save(member);
    Member result = repository.findById(member.getId()).get();
    Assertions.assertThat(member).isEqualTo(result);
  }

  @Test
  public void findByName() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    Member result = repository.findByName("spring1").get();
  }
}
