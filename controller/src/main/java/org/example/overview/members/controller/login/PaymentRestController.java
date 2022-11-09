package org.example.overview.members.controller.login;


import org.example.overview.members.dto.PaymentDTO;
import org.example.overview.members.dto.ProdDTO;
import org.example.overview.members.entity.Prod;
import org.example.overview.members.vo.PaymentVO;
import org.example.overview.members.vo.ProdVO;
import org.example.overview.members.service.PaymentService;
import org.example.overview.members.service.ProdService;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shopping")
public class PaymentRestController {

    private PaymentService paymentService;
    private ProdService prodService;

    @Autowired
    public PaymentRestController(PaymentService paymentService, ProdService prodService){
        this.paymentService = paymentService;
        this.prodService = prodService;
    }

    @GetMapping("/payment")
    public ResponseEntity<String> getPaymentByoId(@RequestParam String oId){
        String result = "";
        PaymentDTO paymentDTO = paymentService.getPaymentById(oId);
        ProdDTO prodDTO = prodService.getByOrderNo(oId);
        result = prodDTO.toString() + paymentDTO.toString();
        System.out.println(result);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("/payment")
    public ResponseEntity<Status> removePaymentByoId(@RequestParam String oId,
                                                     @RequestParam(required = false) String agree){
        if(agree == null || !agree.equals("yes"))   return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);

        Status status = paymentService.deletePaymentById(oId) ? Status.SUCCESS : Status.FAIL;

        return new ResponseEntity<>(status,HttpStatus.OK);

    }
}
