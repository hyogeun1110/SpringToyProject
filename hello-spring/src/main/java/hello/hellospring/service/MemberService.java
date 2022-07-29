package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberReposistory;

    public MemberService(MemberRepository memberReposistory){
        this.memberReposistory = memberReposistory;
    }

    /**
    * 회원가입
    */
    public Long join(Member member){
        // 중복 확인
        validateDuplicateMember(member);

        memberReposistory.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberReposistory.findByName(member.getName())
            .ifPresent(m -> { throw new IllegalStateException("이미 존재하는 회원입니다"); });
    }

    /**
     * 전체 조회
     */
    public List<Member> findMembers(){
        return memberReposistory.findAll();
    }

    /**
     * 회원 하나 조회
     */
    public Optional<Member> findOneMember(Long memberId){
        return memberReposistory.findById(memberId);
    }
}
