package org.example.overview.members.VO;

import java.util.Objects;

public class PaymentVO {
    String oId = "";
    String uId = "";
    String type = "";
    String time = "";
    String amount = "";
    String get_npoint = "";
    String use_npoint = "";
    public PaymentVO(){

    }

    public PaymentVO(String oId, String uId, String type, String time, String amount, String get_npoint, String use_npoint) {
        this.oId = oId;
        this.uId = uId;
        this.type = type;
        this.time = time;
        this.amount = amount;
        this.get_npoint = get_npoint;
        this.use_npoint = use_npoint;
    }

    public String getoId() {
        return oId;
    }

    public String getuId() {
        return uId;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
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
        return Objects.equals(oId, paymentVO.oId) && Objects.equals(uId, paymentVO.uId) && Objects.equals(type, paymentVO.type) && Objects.equals(time, paymentVO.time) && Objects.equals(amount, paymentVO.amount) && Objects.equals(get_npoint, paymentVO.get_npoint) && Objects.equals(use_npoint, paymentVO.use_npoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oId, uId, type, time, amount, get_npoint, use_npoint);
    }

    @Override
    public String toString() {
        return "PaymentVO{" +
                "oId='" + oId + '\'' +
                ", uId='" + uId + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", amount='" + amount + '\'' +
                ", get_npoint='" + get_npoint + '\'' +
                ", use_npoint='" + use_npoint + '\'' +
                '}';
    }
}

