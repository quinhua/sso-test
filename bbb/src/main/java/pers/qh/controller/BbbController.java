package pers.qh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class BbbController {
    @GetMapping("/bbb")
    public String aaa(
            @RequestParam(value = "token",required = false) String token,
            HttpSession session
    ){
        if(!StringUtils.isEmpty(token)){
            session.setAttribute("username","admin");
        }
        return "bbb";
    }
}