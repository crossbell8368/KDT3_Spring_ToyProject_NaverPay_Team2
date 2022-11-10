package org.example.overview.members.controller.login;

import org.example.overview.members.dto.ProdDTO;
import org.example.overview.members.service.ProdService;
import org.example.overview.sessions.SessionMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class PayhomeController {

    private String uId;
    private ProdService prodService;
    private SessionMgr sessionMgr;

    @Autowired
    public PayhomeController(ProdService prodService, SessionMgr sessionMgr) {
        this.prodService = prodService;
        this.sessionMgr = sessionMgr;
    }

    @GetMapping("/payhome")
    public String searchPage(Model model, HttpSession session) {
        System.out.println("searchPage() 메서드 실행");

        String view = "members/login/payhome";

        if (session.getAttribute("SESSION_ID") == null) {
            System.out.println("제한된 페이지입니다. 로그인을 수행해주세요");

            return "redirect:/login";
        }

        uId = sessionMgr.getuIdInSession(session);
        System.out.println(uId + "님의 쇼핑 리스트 출력 결과");

        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.getuIdInSession(session));
        }

        List<ProdDTO> prodDTOList = prodService.getAllProds(uId);
        printProd(prodDTOList);

        return view;
    }

    @PostMapping("/payhome")
    @ResponseBody
    public String listUpByDate(@RequestParam String start, @RequestParam String end, HttpSession session){
        System.out.println("listUpByDate() 메서드 실행");

        if (session.getAttribute("SESSION_ID") == null) {
            System.out.println("제한된 페이지입니다. 로그인을 수행해주세요");

            return "redirect:/login";
        }

        uId = sessionMgr.getuIdInSession(session);
        System.out.println(uId + "님의 쇼핑 리스트 출력 결과");

        if ((start == null || start.equals("")) || (end == null || end.equals(""))){
            System.out.println("잘못된 기간입니다. 기존 리스트를 출력합니다.");

            List<ProdDTO> prodDTOList = prodService.getAllProds(uId);
            printProd(prodDTOList);
        } else {
            System.out.println(start + " ~ " + end + " 사이의 쇼핑 리스트를 출력합니다.");

            List<ProdDTO> prodDTOList = prodService.getProdlistByDate(uId, start, end);
            if (prodDTOList.isEmpty()) {
                System.out.println("해당하는 기간에 쇼핑 정보가 없습니다.");
            }
            printProd(prodDTOList);
        }

        return "";
    }

    public void printProd(List<ProdDTO> prodDTOList) {
        if (prodDTOList != null) {
            for (int i = 0; i < prodDTOList.size(); i++) {
                System.out.println(prodDTOList.get(i).toVO());
            }
        }
    }
}
