package org.example.overview.members.controller.login;


import org.example.overview.members.dto.PaymentDTO;
import org.example.overview.members.dto.ProdDTO;
import org.example.overview.members.vo.DetailVO;
import org.example.overview.members.service.PaymentService;
import org.example.overview.members.service.ProdService;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payhome")
public class PaymentRestController {

    private PaymentService paymentService;
    private ProdService prodService;

    @Autowired
    public PaymentRestController(PaymentService paymentService, ProdService prodService){
        this.paymentService = paymentService;
        this.prodService = prodService;
    }
    @GetMapping("/payment")
    public ResponseEntity<DetailVO> getPaymentByoId(@RequestParam String oId) {
        System.out.println("getPaymentByOId() 메서드 실행");

        PaymentDTO paymentDTO = paymentService.getPaymentById(oId);

        ProdDTO prodDTO = prodService.getProdByOrderNo(oId);

        DetailVO detailVO = new DetailVO(prodDTO.toVO(), paymentDTO.toVO());

        return new ResponseEntity(detailVO, HttpStatus.OK);
    }
    @DeleteMapping("/payment")
    public ResponseEntity<Status> removePaymentByoId(@RequestParam String oId,
                                                     @RequestParam(required = false) String agree){
        System.out.println("removePaymentByoId() 메서드 실행");

        if(agree == null || !agree.equals("yes"))   return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);


        Status status = (paymentService.deletePaymentById(oId) && prodService.removeProdByOrderNo(oId)) ? Status.SUCCESS : Status.FAIL;

        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
