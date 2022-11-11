package org.example.overview.members.controller.login;

import org.example.overview.members.dto.PaymentDTO;
import org.example.overview.members.dto.ProdDTO;
import org.example.overview.members.service.PaymentService;
import org.example.overview.members.service.ProdService;
import org.example.overview.members.vo.DetailVO;
import org.example.overview.sessions.SessionMgr;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class PaymentRestController {

    private PaymentService paymentService;
    private ProdService prodService;
    private SessionMgr sessionMgr;

    @Autowired
    public PaymentRestController(PaymentService paymentService, ProdService prodService, SessionMgr sessionMgr) {
        this.paymentService = paymentService;
        this.prodService = prodService;
        this.sessionMgr = sessionMgr;
    }

    @GetMapping("/payhome/payment")
    public ResponseEntity<DetailVO> getPaymentByoId(@RequestParam String oId,
                                                    HttpServletResponse response,
                                                    HttpSession session) throws IOException {
        System.out.println("getPaymentByOId() 메서드 실행");

        if (session.getAttribute("SESSION_ID") == null) {
            System.out.println("제한된 페이지입니다. 로그인을 수행해주세요");

            response.sendRedirect("/login");
        } else {

            PaymentDTO paymentDTO = paymentService.getPaymentById(oId);
            ProdDTO prodDTO = prodService.getProdByOrderNo(oId);

            if(prodDTO.getoId().equals("") || paymentDTO.getoId().equals("")){
                System.out.println("해당 정보가 존재하지 않습니다. 주문번호를 확인하세요.");

                response.sendRedirect("/payhome");
                return null;
            }

            if (!prodDTO.getuId().equals(sessionMgr.getuIdInSession(session))) {
                System.out.println("올바르지않은 접근입니다. 본인의 쇼핑 정보만 조회 가능합니다.");

                response.sendRedirect("/payhome");
                return null;
            }

            DetailVO detailVO = new DetailVO(prodDTO.toVO(), paymentDTO.toVO());
            System.out.println(detailVO);

            return new ResponseEntity<>(detailVO, HttpStatus.OK);
        }
        return null;
    }

    @DeleteMapping("/payhome/payment")
    public ResponseEntity<Status> removePaymentByoId(@RequestParam String oId,
                                                     @RequestParam(required = false) String agree,
                                                     HttpServletResponse response,
                                                     HttpSession session) throws IOException {
        System.out.println("removePaymentByoId() 메서드 실행");

        if (session.getAttribute("SESSION_ID") == null) {
            System.out.println("제한된 페이지입니다. 로그인을 수행해주세요");

            response.sendRedirect("/login");
        } else {
            ProdDTO prodDTO = prodService.getProdByOrderNo(oId);

            if(prodDTO.getoId().equals("")){
                System.out.println("해당 정보가 존재하지 않습니다. 주문번호를 확인하세요.");

                response.sendRedirect("/payhome");
                return null;
            }

            if (!prodDTO.getuId().equals(sessionMgr.getuIdInSession(session))) {
                System.out.println("올바르지않은 접근입니다. 본인의 쇼핑 정보만 삭제 가능합니다.");

                response.sendRedirect("/payhome");
                return null;
            }

            if (agree == null || !agree.equals("yes")) {
                System.out.println("삭제를 원하시면 'yes' 를 입력해주세요.");

                return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);
            }

            Status status = (paymentService.deletePaymentById(oId) && prodService.removeProdByOrderNo(oId))
                    ? Status.SUCCESS : Status.FAIL;
            System.out.println(oId + "번 상품의 쇼핑 정보를 삭제하는데 " + status + " 하였습니다.");

            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        return null;
    }
}
