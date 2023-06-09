package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j // Logger log = LoggerFactory.getLogger(getClass()); 와 같다.
public class HomeController {

    @RequestMapping("/")
    public String Home(){
        log.info("home controller");
        return "home";
    }
}
