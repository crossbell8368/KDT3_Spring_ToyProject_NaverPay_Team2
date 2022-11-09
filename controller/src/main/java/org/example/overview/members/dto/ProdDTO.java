package org.example.overview.members.dto;

import org.example.overview.members.vo.ProdVO;

public class ProdDTO {
    private String uId="";
    private String oId="";
    private String orderDate="";
    private String manufacture="";
    private String productInfo="";
    private String cost="";
    private int productCount;
    private String seller="";
    private String sellNum="";
    private int status;
    private int review;

    public ProdDTO(){
    }

    public ProdDTO(String uId, String oId, String orderDate, String manufacture, String productInfo, String cost, int productCount, String seller, String sellNum, int status, int review) {
        this.uId = uId;
        this.oId = oId;
        this.orderDate = orderDate;
        this.manufacture = manufacture;
        this.productInfo = productInfo;
        this.cost = cost;
        this.productCount = productCount;
        this.seller = seller;
        this.sellNum = sellNum;
        this.status = status;
        this.review = review;
    }

    public ProdDTO(String oId, String orderDate, String manufacture, String productInfo, String cost, int productCount, String seller, String sellNum, int status) {
        this.oId = oId;
        this.orderDate = orderDate;
        this.manufacture = manufacture;
        this.productInfo=productInfo;
        this.cost = cost;
        this.productCount = productCount;
        this.seller = seller;
        this.sellNum = sellNum;
        this.status = status;
    }

    //public Prod toEntity(){return new Shopping(orderNo,orderDate, manufacture,productInfo,cost,productCount,seller,sellNum,status);}
    public ProdVO toVO() {
        return new ProdVO(oId, orderDate, manufacture,productInfo,cost,productCount,seller,sellNum,status);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getOrderNo() {
        return oId;
    }

    public void setOrderNo(String oId) {
        this.oId = oId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getProductCount() {
        return String.valueOf(productCount);
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getSellNum() {
        return sellNum;
    }

    public void setSellNum(String sellNum) {
        this.sellNum = sellNum;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReview() {
        return String.valueOf(review);
    }

    public void setReview(int review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "ProdDTO{" +
                "uId='" + uId + '\'' +
                ", oId=" + oId +
                ", orderDate='" + orderDate + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", productInfo='" + productInfo + '\'' +
                ", cost='" + cost + '\'' +
                ", productCount=" + productCount +
                ", seller='" + seller + '\'' +
                ", sellNum='" + sellNum + '\'' +
                ", status=" + status +
                ", review=" + review +
                '}';
    }
}
