package jpabook.jpashop.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/*
* createMemberForm.html에서 MemberForm을 파라미터로 쓰고있다.
* 근데 뭐하러 객체를 새로 만드는겨? Member 엔티티를 그냥 직접 사용하면 안대나?
* 요구사항이 단순하면 Member엔티티를 화면에서 직접 사용해도 된다.
* 하지만 요구사항이 조금만 복잡해지면, 엔티티에 화면을 처리하기 위한 기능이 점점 증가한다.
* 결과적으로 엔티티는 점점 화면에 종속적으로 변하고, 이렇게 화면 기능 때문에 지저분해진 엔티티는 결국 유지보수하기 어려워진다.
* 실무에서 엔티티는 핵심 비즈니스 로직만 가지고 있고, 화면을 위한 로직은 없어야 한다.
* 화면이나 API에 맞는 폼 객체나 DTO를 사용하자.
* */
@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다") // validation
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
