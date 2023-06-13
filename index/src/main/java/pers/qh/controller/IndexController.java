package pers.qh.controller;

import org.springframework.stereotype.Controller;
import org.thymeleaf.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping
    public String index(
            @RequestParam(value = "token", required = false) String token, HttpSession session
    ) {
        //模拟token验证
        if (!StringUtils.isEmpty(token)) {
            session.setAttribute("username", "admin");
            session.setAttribute("token", token);
        }
        return "index";
    }

    @GetMapping("/out")
    public String out(HttpSession session) {
        session.removeAttribute("username");
        session.removeAttribute("token");
        return "redirect:" + "http://localhost:8080/";
    }
}
