package org.example.overview.members.entity;

import org.example.overview.members.dto.ProdDTO;

public class Prod {
    /*
    Id / 주문번호 / 주문일 / 제조사 / 상품내역 / 상품금액 / 상품수량 / 판매자이름 / 판매자 전화번호 / 결제상태 / 주문내역
     */
    private String uId="";
    private String oId;
    private String orderDate;
    private String manufacture="";
    private String productInfo="";
    private String cost="";
    private int productCount;
    private String seller="";
    private String sellNum="";
    private int status;
    private int review;

    public Prod() {
    }

    public Prod(String uId, String oId, String orderDate, String manufacture, String productInfo, String cost, String productCount, String seller, String sellNum, String status, String review) {
        this.uId = uId;
        this.oId = oId;
        this.orderDate = orderDate;
        this.manufacture = manufacture;
        this.productInfo = productInfo;
        this.cost = cost;
        this.productCount = Integer.parseInt(productCount);
        this.seller = seller;
        this.sellNum = sellNum;
        this.status = Integer.parseInt(status);
        this.review = Integer.parseInt(review);
    }

    public Prod(String oId, String orderDate, String manufacture, String productInfo, String cost, int productCount, String seller, String sellNum, int status) {
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

    public String getuId() {
        return uId;
    }

    public String getOrderNo() {
        return oId;
    }

    public ProdDTO toDTO() {
        return new ProdDTO(
                uId,
                oId,
                orderDate,
                manufacture,
                productInfo,
                cost,
                productCount,
                seller,
                sellNum,
                status,
                review
        );
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

    public String getProductCount() {
        return String.valueOf(productCount);
    }

    public String getSeller() {
        return seller;
    }

    public String getSellNum() {
        return sellNum;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public String getReview() {
        return String.valueOf(review);
    }

    @Override
    public String toString() {
        return "Prod{" +
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
