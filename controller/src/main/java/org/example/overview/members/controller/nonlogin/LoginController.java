package org.example.overview.members.controller.nonlogin;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.service.MemberService;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 새롭게 생성한 Login 브런치 입니다.
@Controller
@RequestMapping("/")
public class LoginController {

    private SessionMgr sessionMgr; // = SessionMgr.getInstance();
    private CookieMgr cookieMgr; // = CookieMgr.getInstance();
    private MemberService memberService ; //= MemberService.getInstance();


    @Autowired
    public LoginController(SessionMgr sessionMgr, CookieMgr cookieMgr, MemberService memberService) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, HttpSession session) {
        String view = "login";

        if (session.getAttribute("SESSION_ID") != null) { // 로그인이 되어있는 상태
            return "redirect:/";
        }

        String autoLogin = cookieMgr.get(request, "AUTO_LOGIN");
        String cookieId = cookieMgr.get(request, "COOKIE_ID");


        if (autoLogin != null && cookieId != null) {
            if (memberService.autoLogin(autoLogin, cookieId)) {
                sessionMgr.create(session, cookieId);
                view = "redirect:/";
            }
        }

        return view;
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String uId, @RequestParam String uPw, @RequestParam(required = false) String save,
                          Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        String view = loginPage(request, session);
        Status respStatus = Status.FAIL;

        MemberDTO memberDTO = memberService.login(uId, uPw);
        if (memberDTO != null) {
            sessionMgr.create(session, uId);

            saveCookieForAutoLogin(uId, save, response);

            view = "redirect:/";
            respStatus = Status.SUCCESS;
        }


        session.setAttribute("login", respStatus);
        model.addAttribute("uId", session.getAttribute("SESSION_ID"));

        return view;

    }

    private void saveCookieForAutoLogin(String uId, String save, HttpServletResponse response) {
        if (save == null) return;

        if (save.equals("on")) {
            cookieMgr.create(response, new String[] {uId, "true"});
        }
    }

}


