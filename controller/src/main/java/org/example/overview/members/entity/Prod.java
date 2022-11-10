package org.example.overview.members.entity;

import org.example.overview.members.dto.ProdDTO;

public class Prod {

    private String oId = "";
    private String uId = "";
    private String orderDate = "";
    private String productName = "";
    private String amount = "";
    private String status = "";
    private String company;
    private String companyTel = "";

    public Prod() {
    }

    public Prod(String oId, String uId, String orderDate,
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

    public Prod(String oId, String orderDate, String productName,
                String amount, String status, String company, String companyTel) {
        this.oId = oId;
        this.orderDate = orderDate;
        this.productName = productName;
        this.amount = amount;
        this.status = status;
        this.company = company;
        this.companyTel = companyTel;
    }

    public ProdDTO toDTO() {
        return new ProdDTO(oId, uId, orderDate, productName, amount, status, company, companyTel);
    }

    public String getoId() {
        return oId;
    }

    public String getuId() {
        return uId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getProductName() {
        return productName;
    }

    public String getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public String getCompany() {
        return company;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    @Override
    public String toString() {
        return "Prod{" +
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
