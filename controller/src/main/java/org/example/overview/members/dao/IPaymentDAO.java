package org.example.overview.members.DAO;

import org.example.overview.members.entity.Payment;

public interface IPaymentDAO {
    Payment select(String oId);
    int delete(String id);
}
