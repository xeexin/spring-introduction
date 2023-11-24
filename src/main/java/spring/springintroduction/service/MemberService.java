package spring.springintroduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.springintroduction.domain.Member;
import spring.springintroduction.repository.MemberRepository;
import spring.springintroduction.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public long join(Member member) {

        long start = System.currentTimeMillis();

        try {
            //같은 이름 no
            validateDuplicateMember(member);

            memberRepository.save(member);
            return member.getId();

        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + " ms");
        }

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        long start = System.currentTimeMillis();
        try {

            return memberRepository.findAll();

        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("회원 조회 " + timeMs + " ms");
        }
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
