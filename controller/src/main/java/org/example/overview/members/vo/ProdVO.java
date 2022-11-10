package org.example.overview.members.vo;

import java.util.Objects;

public class ProdVO {

    private String oId = "";
    private String uId = "";
    private String orderDate = "";
    private String productName = "";
    private String amount = "";
    private String status = "";
    private String company;
    private String companyTel = "";

    public ProdVO(String oId, String uId, String orderDate,
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

    public ProdVO(String oId, String orderDate, String productName,
                  String amount, String status, String company, String companyTel) {
        this.oId = oId;
        this.orderDate = orderDate;
        this.productName = productName;
        this.amount = amount;
        this.status = status;
        this.company = company;
        this.companyTel = companyTel;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdVO prodVO = (ProdVO) o;
        return Objects.equals(oId, prodVO.oId) && Objects.equals(uId, prodVO.uId) && Objects.equals(orderDate, prodVO.orderDate) && Objects.equals(productName, prodVO.productName) && Objects.equals(amount, prodVO.amount) && Objects.equals(status, prodVO.status) && Objects.equals(company, prodVO.company) && Objects.equals(companyTel, prodVO.companyTel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oId, uId, orderDate, productName, amount, status, company, companyTel);
    }

    @Override
    public String toString() {
        return "ProdVO{" +
                "oId='" + oId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", productName='" + productName + '\'' +
                ", amount='" + amount + '\'' +
                ", status='" + status + '\'' +
                ", company='" + company + '\'' +
                ", companyTel='" + companyTel + '\'' +
                '}';
    }
}
