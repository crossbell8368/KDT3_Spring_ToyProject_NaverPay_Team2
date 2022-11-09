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
@RequestMapping("/payhome")
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

        String view = "members/login/search";

        if (session.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        if (session.getAttribute("SESSION_ID") != null) {
            model.addAttribute("uId", sessionMgr.get(session));
        }

        return view;
    }

    @PostMapping("/payhome")
    @ResponseBody
    public String listUpByDate(@RequestParam String start, @RequestParam String end, HttpSession sess){
        if (sess.getAttribute("SESSION_ID") == null) {
            return "redirect:/";
        }

        if ((start == null || start.equals("")) || (end == null || end.equals(""))){
            return getAllProd(sess);
        }

        uId = sessionMgr.get(sess);
        List<ProdDTO> prodDTOList = prodService.listByDate(uId, start, end);

        if (prodDTOList != null) {
            return parseListToJSONArrayString(prodDTOList);
        }
        return "";

    }

    public String getAllProd(HttpSession sess){
        List<ProdDTO> prodDTOList = prodService.getAllProds();
        if (prodDTOList != null) {
            return parseListToJSONArrayString(prodDTOList);
        }

        return "";
    }

    public String parseListToJSONArrayString(List<ProdDTO> prodDTOList) {
        JSONArray jsonArray = new JSONArray(); // List<Map<>>
        for (int i = 0; i < prodDTOList.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("USER_ID", prodDTOList.get(i).getuId());
            map.put("ORDER_NO", prodDTOList.get(i).getOrderNo());
            map.put("ORDER_DATE", prodDTOList.get(i).getOrderDate());
            map.put("PROD_MANUF", prodDTOList.get(i).getManufacture());
            map.put("PROD_INFO", prodDTOList.get(i).getProductInfo());
            map.put("PROD_COST", prodDTOList.get(i).getCost());
            map.put("PROD_CNT", prodDTOList.get(i).getProductCount());
            map.put("PROD_SELLER", prodDTOList.get(i).getSeller());
            map.put("PROD_SELLNUM", prodDTOList.get(i).getSellNum());
            map.put("PROD_STATUS", prodDTOList.get(i).getStatus());
            map.put("PROD_REVIEW", prodDTOList.get(i).getReview());

            JSONObject jsonObject = new JSONObject(map);
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }

    public String parseObjectToJSONObjectString(ProdDTO prodDTO) {
        Map<String, String> map = new HashMap<>();
        map.put("USER_ID", prodDTO.getuId());
        map.put("ORDER_NO", prodDTO.getOrderNo());
        map.put("ORDER_DATE", prodDTO.getOrderDate());
        map.put("PROD_MANUF", prodDTO.getManufacture());
        map.put("PROD_INFO", prodDTO.getProductInfo());
        map.put("PROD_COST", prodDTO.getCost());
        map.put("PROD_CNT", prodDTO.getProductCount());
        map.put("PROD_SELLER", prodDTO.getSeller());
        map.put("PROD_SELLNUM", prodDTO.getSellNum());
        map.put("PROD_STATUS", prodDTO.getStatus());
        map.put("PROD_REVIEW", prodDTO.getReview());

        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toString();
    }
}
