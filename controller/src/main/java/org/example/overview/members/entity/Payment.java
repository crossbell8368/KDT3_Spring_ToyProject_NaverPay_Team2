package org.example.overview.members.Entity;

import org.example.overview.members.DTO.PaymentDTO;

public class Payment {
    String oId = "";
    String uId = "";
    String type = "";
    String time = "";
    String amount = "";
    String get_npoint = "";
    String use_npoint = "";

    public Payment(){
    }

    public Payment(String oId, String uId, String type, String time, String amount, String get_npoint, String use_npoint) {
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
        return oId;
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

    public PaymentDTO toDTO(){
        return new PaymentDTO(oId, uId, type, time, amount, get_npoint, use_npoint);
    }

    @Override
    public String toString() {
        return "Payment{" +
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
