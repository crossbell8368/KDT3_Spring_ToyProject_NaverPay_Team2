package org.example.overview.members.controller;

import org.example.overview.sessions.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    private SessionMgr sessionMgr;

    @Autowired
    public IndexController(SessionMgr sessionMgr) {
        this.sessionMgr = sessionMgr;
    }

    @GetMapping("/")
    public String indexPage(Model model, HttpSession session) {
        System.out.println("indexPage() 메서드 실행");

        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.getuIdInSession(session));
        }
        return "index";
    }
}
