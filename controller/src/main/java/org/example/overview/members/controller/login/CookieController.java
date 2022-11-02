package org.example.overview.members.controller.login;

import org.example.overview.cookies.CookieMgr;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/members")
public class CookieController { // 쿠키 컨트롤러
    private final SessionMgr sessionMgr; // = SessionMgr.getInstance();
    private final CookieMgr cookieMgr; // = CookieMgr.getInstance();

    @Autowired
    public CookieController(SessionMgr sessionMgr, CookieMgr cookieMgr) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
    }

    @GetMapping("/cookies")
    public String cookiePage(Model model, HttpServletRequest request, HttpSession session) {
        String view = "members/login/cookie";

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        Map<String, String> cookies = new HashMap<>();

        model.addAttribute("uId", sessionMgr.get(session));

        cookies.put("JSESSIONID", cookieMgr.get(request, "JSESSIONID"));
        cookies.put("COOKIE_ID", cookieMgr.get(request, "COOKIE_ID"));
        cookies.put("AUTO_LOGIN", cookieMgr.get(request, "AUTO_LOGIN"));
        model.addAttribute("cookies", cookies);


        return view;
    }

    @GetMapping("/cookies/{cookieName}")
    public String getCookieByName(@PathVariable String cookieName, Model model, HttpServletRequest request, HttpSession session) {
        String view = "members/login/cookie";

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        if (cookieName == null || cookieName.equals("")) return view;

        Map<String, String> cookies = new HashMap<>();
        model.addAttribute("uId", sessionMgr.get(session));

        cookies.put(cookieName, cookieMgr.get(request, cookieName));
        model.addAttribute("cookies", cookies);

        return view;
    }

    @PostMapping("/cookies/rm")
    public String removeCookieByName(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        String view = "redirect:/members/cookies";

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        String[] values = null;
        if (request.getParameter("cookie") != null) {
            values = request.getParameterValues("cookie");
        }

        int count = cookieMgr.delete(request, response, values);

        if (count > 0) {
            session.setAttribute("cookie", Status.SUCCESS);
        } else {
            session.setAttribute("cookie", Status.FAIL);
        }

        return view;
    }
}
