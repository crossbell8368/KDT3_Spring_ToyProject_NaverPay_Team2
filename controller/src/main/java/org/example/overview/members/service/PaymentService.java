package org.example.overview.members.service;

import org.example.overview.members.DAO.PaymentDAO;
import org.example.overview.members.DTO.PaymentDTO;
import org.example.overview.members.Entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService{

    private PaymentDAO paymentDAO;

    @Autowired
    public PaymentService(PaymentDAO paymentDAO){
        this.paymentDAO = paymentDAO;
    }

    @Override
    public boolean save(String uId, String title, String completed) {
        if(uId == null || title == null || completed==null) return false;
        return false;
    }

    @Override
    public PaymentDTO getPaymentById(String oId, String uId) {
        if (uId == null) return null;

        Payment payment= paymentDAO.select(oId, uId);
        if (payment == null) return null;

        return payment.toDTO();
    }

    @Override
    public boolean deletePaymentById(String oId, String uId) {
        if(oId== null || uId == null) return false;

        Payment payment = paymentDAO.select(oId,uId);
        if( payment == null) return false;

        int res = paymentDAO.delete(oId);
        return res > 0;
    }
}
