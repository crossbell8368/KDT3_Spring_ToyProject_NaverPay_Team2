package org.example.overview.members.service;

import org.example.overview.members.dto.PaymentDTO;

public interface IPaymentService {
    PaymentDTO getPaymentById(String oId);
    boolean deletePaymentById(String oId);
}
