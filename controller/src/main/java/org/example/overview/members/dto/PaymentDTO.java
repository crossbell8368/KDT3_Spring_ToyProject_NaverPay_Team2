package org.example.overview.members.dto;

import org.example.overview.members.entity.Payment;
import org.example.overview.members.vo.PaymentVO;

public class PaymentDTO {
    String oId = "";
    String type = "";
    String time = "";
    String amount = "";
    String get_npoint = "";
    String use_npoint = "";

    public PaymentDTO(){

    }

    public PaymentDTO(String oId, String type, String time, String amount, String get_npoint, String use_npoint) {
        this.oId = oId;
        this.type = type;
        this.time = time;
        this.amount = amount;
        this.get_npoint = get_npoint;
        this.use_npoint = use_npoint;
    }

    public PaymentVO toVO(){
        return new PaymentVO(oId, type, time, amount, get_npoint, use_npoint);
    }

    public Payment toEntity(){
        return new Payment(oId, type, time, amount, get_npoint, use_npoint);
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGet_npoint() {
        return get_npoint;
    }

    public void setGet_npoint(String get_npoint) {
        this.get_npoint = get_npoint;
    }

    public String getUse_npoint() {
        return use_npoint;
    }

    public void setUse_npoint(String use_npoint) {
        this.use_npoint = use_npoint;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "oId='" + oId + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", amount='" + amount + '\'' +
                ", get_npoint='" + get_npoint + '\'' +
                ", use_npoint='" + use_npoint + '\'' +
                '}';
    }
}

