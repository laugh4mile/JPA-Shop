package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    // 엔티티매니저 주입.
    // @PersistenceContext //스프링부트와 스프링 데이터 JPA를 쓰면 @Autowired로 대체 가능하다.
    // 생성자가 1개일 경우 Autowired를 생략할 수 있다.
    private final EntityManager em;

    public void save(Member member){
        em.persist(member); // 영속성 컨텍스트에 member 객체를 넣음 => 트랜잭션이 커밋되는 시점에 DB에 반영
    }

    public Member findOne(Long id){
        return em.find(Member.class, id); // 첫번째 : 타입, 두번째 : PK
    }



    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class) // jpql.(쿼리, 타입)
                .getResultList();
    }

    // :nema : 파라미터 바인딩
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
