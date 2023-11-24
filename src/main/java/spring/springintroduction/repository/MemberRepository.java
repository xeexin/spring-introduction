package spring.springintroduction.repository;

import org.springframework.stereotype.Repository;
import spring.springintroduction.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
