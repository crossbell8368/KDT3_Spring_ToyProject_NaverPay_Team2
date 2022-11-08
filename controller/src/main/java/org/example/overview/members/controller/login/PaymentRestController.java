package org.example.overview.members.restcontroller;


import org.example.overview.members.DTO.PaymentDTO;
import org.example.overview.members.VO.PaymentVO;
import org.example.overview.members.service.PaymentService;
import org.example.overview.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping")
public class PaymentRestController {

    private PaymentService paymentService;

    @Autowired
    public PaymentRestController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public ResponseEntity<PaymentVO> getPaymentByoId(@RequestParam String oId,
                                                     @RequestParam String uId){
        PaymentDTO paymentDTO = paymentService.getPaymentById(oId, uId);

        return new ResponseEntity(paymentDTO.toVO(), HttpStatus.OK);
    }

    @DeleteMapping("/payment")
    public ResponseEntity<Status> removePaymentByoId(@RequestParam String oId,
                                                     @RequestParam String uId,
                                                     @RequestParam(required = false) String agree){
        if(agree == null || !agree.equals("yes"))   return new ResponseEntity<>(Status.NULL, HttpStatus.BAD_REQUEST);

        Status status = paymentService.deletePaymentById(oId, uId) ? Status.SUCCESS : Status.FAIL;

        return new ResponseEntity<>(status,HttpStatus.OK);

        }

}
