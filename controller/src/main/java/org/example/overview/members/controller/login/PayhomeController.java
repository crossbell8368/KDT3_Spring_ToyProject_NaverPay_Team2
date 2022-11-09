package org.example.overview.members.controller.login;

import org.example.overview.members.dto.ProdDTO;
import org.example.overview.members.service.ProdService;
import org.example.overview.sessions.SessionMgr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class PayhomeController { // 유저 검색 페이지 컨트롤러

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
        // 로그인 후 등장하는 페이지 컨트롤러
        // 로그인ID에 해당되는 모든 결제상품 출력
        String view = "members/login/payhome";

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }
        uId = sessionMgr.get(session);
        System.out.println(uId + "님의 쇼핑 리스트 출력 결과");

        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.get(session));
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
            return "redirect:/";
        }

        uId = sessionMgr.get(session);
        System.out.println(uId + "님의 쇼핑 리스트 출력 결과");
        if ((start == null || start.equals("")) || (end == null || end.equals(""))){
            System.out.println("잘못된 기간입니다. 기존 리스트를 출력합니다.");
            List<ProdDTO> prodDTOList = prodService.getAllProds(uId);
            printProd(prodDTOList);
        } else {
            System.out.println(start + " ~ " + end + " 사이의 쇼핑 리스트를 출력합니다.");
            List<ProdDTO> prodDTOList = prodService.getProdlistByDate(uId, start, end);
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

    // TODO: 이거 굳이필요한가?
    // public String parseListToJSONArrayString(List<ProdDTO> prodDTOList) {
    //     JSONArray jsonArray = new JSONArray(); // List<Map<>>
    //     for (int i = 0; i < prodDTOList.size(); i++) {
    //         Map<String, String> map = new HashMap<>();
    //         map.put("uId", prodDTOList.get(i).getuId());
    //         map.put("oId", prodDTOList.get(i).getOrderNo());
    //         map.put("ORDER_DATE", prodDTOList.get(i).getOrderDate());
    //         map.put("PROD_MANUF", prodDTOList.get(i).getManufacture());
    //         map.put("PROD_INFO", prodDTOList.get(i).getProductInfo());
    //         map.put("PROD_COST", prodDTOList.get(i).getCost());
    //         map.put("PROD_CNT", prodDTOList.get(i).getProductCount());
    //         map.put("PROD_SELLER", prodDTOList.get(i).getSeller());
    //         map.put("PROD_SELLNUM", prodDTOList.get(i).getSellNum());
    //         map.put("PROD_STATUS", prodDTOList.get(i).getStatus());
    //         map.put("PROD_REVIEW", prodDTOList.get(i).getReview());
    //
    //         JSONObject jsonObject = new JSONObject(map);
    //         jsonArray.put(jsonObject);
    //     }
    //     return jsonArray.toString();
    // }

    // public String parseObjectToJSONObjectString(ProdDTO prodDTO) {
    //     Map<String, String> map = new HashMap<>();
    //     map.put("uId", prodDTO.getuId());
    //     map.put("oId", prodDTO.getOrderNo());
    //     map.put("ORDER_DATE", prodDTO.getOrderDate());
    //     map.put("PROD_MANUF", prodDTO.getManufacture());
    //     map.put("PROD_INFO", prodDTO.getProductInfo());
    //     map.put("PROD_COST", prodDTO.getCost());
    //     map.put("PROD_CNT", prodDTO.getProductCount());
    //     map.put("PROD_SELLER", prodDTO.getSeller());
    //     map.put("PROD_SELLNUM", prodDTO.getSellNum());
    //     map.put("PROD_STATUS", prodDTO.getStatus());
    //     map.put("PROD_REVIEW", prodDTO.getReview());
    //
    //     JSONObject jsonObject = new JSONObject(map);
    //     return jsonObject.toString();
    // }
}
