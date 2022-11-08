package org.example.overview.members.service;

import org.example.overview.members.DTO.PaymentDTO;

public interface IPaymentService {
    boolean save(String uId, String title, String completed);
    PaymentDTO getPaymentById(String oId, String uId);
    boolean deletePaymentById(String oId, String uId);
}
