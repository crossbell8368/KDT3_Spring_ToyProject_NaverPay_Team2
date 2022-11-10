package org.example.overview.members.vo;

import java.util.Objects;

public class PaymentVO {

    String oId = "";
    String orderType = "";
    String orderDate = "";
    String amount = "";
    String get_npoint = "";
    String use_npoint = "";

    public PaymentVO() {
    }

    public PaymentVO(String oId, String orderType, String orderDate,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentVO paymentVO = (PaymentVO) o;
        return Objects.equals(oId, paymentVO.oId) && Objects.equals(orderType, paymentVO.orderType) && Objects.equals(orderDate, paymentVO.orderDate) && Objects.equals(amount, paymentVO.amount) && Objects.equals(get_npoint, paymentVO.get_npoint) && Objects.equals(use_npoint, paymentVO.use_npoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oId, orderType, orderDate, amount, get_npoint, use_npoint);
    }

    @Override
    public String toString() {
        return "PaymentVO{" +
                "oId='" + oId + '\'' +
                ", orderType='" + orderType + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", amount='" + amount + '\'' +
                ", get_npoint='" + get_npoint + '\'' +
                ", use_npoint='" + use_npoint + '\'' +
                '}';
    }
}
