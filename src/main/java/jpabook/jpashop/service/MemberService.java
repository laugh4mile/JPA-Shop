package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // jakarta 보다 spring에서 제공하는 것을 쓰자.

import java.util.List;

@Service
@Transactional(readOnly = true) // JPA의 모든 데이터 변경이나 로직들은 가급적 트랜잭션 안에서 이루어져야 한다.
@RequiredArgsConstructor // final이 붙은 필드로 생성자를 만들어줌. DI도 해줌
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    // class 위에 readOnly = true 를 통해 기본적으로 readOnly로 두고
    // 쓰기(insert) 권한이 필요한 곳에 따로 @Transaction을 쓴다. (default = false)

    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }

}
