package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){ // 모델 : 데이터를 뷰로 넘길수 있는 애
        model.addAttribute("data", "hello!!!");
        return "hello"; // 화면이름. .html이 자동으로 붙음
    }
}
