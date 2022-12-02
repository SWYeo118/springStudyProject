package com.example.sangwoo2.Repository;

import java.util.List;
import java.util.Optional;

import com.example.sangwoo2.Domain.Member;

public interface MemberRepository {
  Member save(Member member);
  // Optional은 Null 처리할 떄 감싸서 반환
  Optional<Member> findById(Long id);
  Optional<Member> findByName(String name);
  List<Member> findAll();
}
