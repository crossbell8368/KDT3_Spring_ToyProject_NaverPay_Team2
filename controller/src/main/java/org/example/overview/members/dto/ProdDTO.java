package org.example.overview.members.dto;

public class ProdDTO {
    private String uId="";
    private int orderNo;
    private String orderDate;
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

    public ProdDTO(int orderNo, String orderDate, String manufacture, String productInfo, String cost, int productCount, String seller, String sellNum, int status) {
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.manufacture = manufacture;
        this.productInfo=productInfo;
        this.cost = cost;
        this.productCount = productCount;
        this.seller = seller;
        this.sellNum = sellNum;
        this.status = status;
    }

    //public Shopping toEntity(){return new Shopping(orderNo,orderDate, manufacture,productInfo,cost,productCount,seller,sellNum,status);}
    //public ShoppingVO toVO(){return new ShoppingVO(orderNo,orderDate, manufacture,productInfo,cost,productCount,seller,sellNum,status);}

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
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

    public int getProductCount() {
        return productCount;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "ProdDTO{" +
                "uId='" + uId + '\'' +
                ", orderNo=" + orderNo +
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
