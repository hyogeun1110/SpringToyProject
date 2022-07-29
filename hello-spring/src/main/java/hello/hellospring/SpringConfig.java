package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }


//    @Bean
//    public MemberRepository memberReposistory(){
//        //return new JdbcTemplateMemberRepository(dataSource);
//        //return new JdbcMemberRepository(dataSource);
//        //return new MemoryMemberRepository();
//        //return new JpaMemberRepository(em);
//    }
}
