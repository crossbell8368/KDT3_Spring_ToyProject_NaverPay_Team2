package org.example.overview.members.DAO;

import org.example.overview.members.Entity.Payment;

public interface IPaymentDAO {
    Payment select(String oId, String uId);
    int delete(String id);
}
