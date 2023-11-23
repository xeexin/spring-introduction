package spring.springintroduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.springintroduction.repository.JdbcMemberRepository;
import spring.springintroduction.repository.JdbcTemplateMemberRepository;
import spring.springintroduction.repository.MemberRepository;
import spring.springintroduction.repository.MemoryMemberRepository;
import spring.springintroduction.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository() );
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
