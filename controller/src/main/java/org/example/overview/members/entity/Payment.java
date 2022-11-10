package org.example.overview.members.entity;

import org.example.overview.members.dto.PaymentDTO;

public class Payment {
    String oId = "";
    String orderType = "";
    String orderDate = "";
    String amount = "";
    String get_npoint = "";
    String use_npoint = "";

    public Payment() {
    }

    public Payment(String oId, String orderType, String orderDate,
                   String amount, String get_npoint, String use_npoint) {
        this.oId = oId;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.amount = amount;
        this.get_npoint = get_npoint;
        this.use_npoint = use_npoint;
    }

    public String getoId() {
        return oId;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getAmount() {
        return amount;
    }

    public String getGet_npoint() {
        return get_npoint;
    }

    public String getUse_npoint() {
        return use_npoint;
    }

    public PaymentDTO toDTO() {
        return new PaymentDTO(oId, orderType, orderDate, amount, get_npoint, use_npoint);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "oId='" + oId + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", amount='" + amount + '\'' +
                ", get_npoint='" + get_npoint + '\'' +
                ", use_npoint='" + use_npoint + '\'' +
                '}';
    }
}
