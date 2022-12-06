package com.example.sangwoo2.Service;

import com.example.sangwoo2.Domain.Member;
import com.example.sangwoo2.Repository.MemberRepository;
import com.example.sangwoo2.Repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class memberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
    * 회원가입
    */
    public Long join(Member member) {
        // 이름이 중복되는 회원은 안됌
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });
        를
        * */
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 이렇게 바꾸어줄 수도 있음. 어차피 ifPresent 한 게 Optional이니까
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
                });
    }

    /*
    * 전체 멤버 조회
    * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
