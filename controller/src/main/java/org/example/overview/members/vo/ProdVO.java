package org.example.overview.members.vo;

import java.util.Objects;
public class ProdVO {
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

    public ProdVO() {
    }

    public ProdVO(String uId, int orderNo, String orderDate, String manufacture, String productInfo, String cost, int productCount, String seller, String sellNum, int status, int review) {
        this.uId = uId;
        this.orderNo = orderNo;
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

    public ProdVO(int orderNo, String orderDate, String manufacture, String productInfo, String cost, int productCount, String seller, String sellNum, int status) {
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

    public String getuId() {
        return uId;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getManufacture() {
        return manufacture;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public String getCost() {
        return cost;
    }

    public int getProductCount() {
        return productCount;
    }

    public String getSeller() {
        return seller;
    }

    public String getSellNum() {
        return sellNum;
    }

    public int getStatus() {
        return status;
    }

    public int getReview() {
        return review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdVO shoppingVO = (ProdVO) o;
        return orderNo == shoppingVO.orderNo && productCount == shoppingVO.productCount
                && status == shoppingVO.status && review == shoppingVO.review && uId.equals(shoppingVO.uId)
                && orderDate.equals(shoppingVO.orderDate) && manufacture.equals(shoppingVO.manufacture)
                && productInfo.equals(shoppingVO.productInfo) && cost.equals(shoppingVO.cost)
                && seller.equals(shoppingVO.seller) && sellNum.equals(shoppingVO.sellNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, orderNo, orderDate, manufacture, productInfo, cost, productCount, seller, sellNum, status, review);
    }


    @Override
    public String toString() {
        return "ProdVO{" +
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
