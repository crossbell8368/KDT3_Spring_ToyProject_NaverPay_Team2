package org.example.overview.members.controller.nonlogin;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

    private SessionMgr sessionMgr;
    private CookieMgr cookieMgr;
    private MemberService memberService;

    @Autowired
    public LoginController(SessionMgr sessionMgr, CookieMgr cookieMgr, MemberService memberService) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, HttpSession session) {
        System.out.println("loginPage() 메서드 실행");

        String view = "/members/nonlogin/login";

        if (session.getAttribute("SESSION_ID") != null) {
            System.out.println("이미 로그인 되어있습니다.");

            return "redirect:/payhome";
        }
        return view;
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String uId,
                          @RequestParam String uPw, Model model,
                          HttpServletRequest request, HttpSession session) {
        System.out.println("doLogin() 메서드 실행");

        String view = loginPage(request, session);
        Status respStatus = Status.FAIL;

        if (!view.equals("redirect:/payhome")) {
            MemberDTO memberDTO = memberService.login(uId, uPw);
            if (memberDTO != null) {
                sessionMgr.createuIdInSession(session, uId);
                view = "redirect:/payhome";
                respStatus = Status.SUCCESS;
            }

            session.setAttribute("login", respStatus);
            model.addAttribute("uId", session.getAttribute("SESSION_ID"));

            System.out.println("로그인 성공 여부 : " + session.getAttribute("login"));

            if (session.getAttribute("login") == Status.SUCCESS) {
                System.out.println(memberService.findUserByuId(memberDTO.getuId()).toVo());
            }
        }
        return view;
    }
}
