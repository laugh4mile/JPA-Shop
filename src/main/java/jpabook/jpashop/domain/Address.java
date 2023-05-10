package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable // 어딘가에 내장이 될 수 있다
@Getter // 값 타입은 변경 불가능하게 설계해야 한다. 따라서 Setter는 쓰지말고 생성자에서 값을 초기화 해야한다.
public class Address {
    private String city;
    private String street;
    private String zipcode;

    // 임베디드 타입은 자바 기본 생성자를 public 또는 protected 로 설정해야 한다.
    // JPA 구현 라이브러리가 객체를 생성할 때 리플렉션, 프록시 같은 기술을 사용할 수 있도록 지원해야하기 때문이다.
    protected Address(){} 

    public Address (String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
