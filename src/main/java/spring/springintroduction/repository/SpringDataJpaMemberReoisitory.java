package spring.springintroduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.springintroduction.domain.Member;

import java.util.Optional;

//인터페이스 다중 상속 가능
public interface SpringDataJpaMemberReoisitory extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
