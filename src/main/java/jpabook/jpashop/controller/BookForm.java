package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

    // 상품공통
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    // Book 관련
    private String author;
    private String isbn;
}
