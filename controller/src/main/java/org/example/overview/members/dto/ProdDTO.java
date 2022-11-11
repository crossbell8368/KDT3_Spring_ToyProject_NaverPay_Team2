package org.example.overview.members.dto;

import org.example.overview.members.vo.ProdVO;

public class ProdDTO {

    private String oId = "";
    private String uId = "";
    private String orderDate = "";
    private String productName = "";
    private String amount = "";
    private String status = "";
    private String company;
    private String companyTel = "";

    public ProdDTO() {
    }

    public ProdDTO(String oId, String uId, String orderDate,
                   String productName, String amount, String status,
                   String company, String companyTel) {
        this.oId = oId;
        this.uId = uId;
        this.orderDate = orderDate;
        this.productName = productName;
        this.amount = amount;
        this.status = status;
        this.company = company;
        this.companyTel = companyTel;
    }

    public ProdDTO(String oId, String orderDate, String productName,
                   String amount, String status, String company, String companyTel) {
        this.oId = oId;
        this.orderDate = orderDate;
        this.productName = productName;
        this.amount = amount;
        this.status = status;
        this.company = company;
        this.companyTel = companyTel;
    }

    public ProdVO toVO() {
        return new ProdVO(oId, orderDate, productName, amount, status, company, companyTel);
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    @Override
    public String toString() {
        return "ProdDTO{" +
                "oId='" + oId + '\'' +
                ", uId='" + uId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", productName='" + productName + '\'' +
                ", amount='" + amount + '\'' +
                ", status='" + status + '\'' +
                ", company='" + company + '\'' +
                ", companyTel='" + companyTel + '\'' +
                '}';
    }
}
