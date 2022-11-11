package org.example.overview.members.service;

import org.example.overview.members.dao.PaymentDAO;
import org.example.overview.members.dto.PaymentDTO;
import org.example.overview.members.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    private PaymentDAO paymentDAO;

    @Autowired
    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    public PaymentDTO getPaymentById(String oId) {
        if (oId == null) return null;

        Payment payment = paymentDAO.select(oId);
        if (payment == null) {
            return new PaymentDTO();
        }
        return payment.toDTO();
    }

    @Override
    public boolean deletePaymentById(String oId) {
        if (oId == null) return false;

        Payment payment = paymentDAO.select(oId);
        if (payment == null) return false;

        int res = paymentDAO.delete(oId);

        return res > 0;
    }
}
