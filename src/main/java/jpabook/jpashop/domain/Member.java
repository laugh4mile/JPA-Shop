package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장 타입을 포함했다는 의미.
    private Address address;

    // Collection은 필드에서 초기화 하는것이 안전하다.
    // 하이버네이트는 엔티티를 영속화 할 때, 컬렉션을 감싸서 하이버네이트 전용 내장 컬렉션으로 변경한다.
    // 따라서 필드에서 초기화하고 건드릴 생각하지 마라.
    @OneToMany(mappedBy = "member") // 하나의 회원이 여러 상품을 주문할 수 있다. 여기서 member는 Order의 member 필드
    private List<Order> orders = new ArrayList<>();

}
