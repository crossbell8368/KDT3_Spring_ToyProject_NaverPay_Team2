package org.example.overview.members.controller;

import org.example.overview.sessions.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    private SessionMgr sessionMgr; //= SessionMgr.getInstance();

    @Autowired
    public IndexController(SessionMgr sessionMgr) {
        this.sessionMgr = sessionMgr;
    }

    // TODO: request -> getuIdInSession
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Model model, HttpSession session) {
        System.out.println("indexPage() 메서드 실행");

        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.getuIdInSession(session));
        }

        return "index";
    }
}
