package org.example.overview.members.entity;

public class Prod {
    /*
    Id / 주문번호 / 주문일 / 제조사 / 상품내역 / 상품금액 / 상품수량 / 판매자이름 / 판매자 전화번호 / 결제상태 / 주문내역
     */
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

    public Prod() {
    }

    public Prod(String uId, int orderNo, String orderDate, String manufacture, String productInfo, String cost, int productCount, String seller, String sellNum, int status, int review) {
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

    public Prod(int orderNo, String orderDate, String manufacture, String productInfo, String cost, int productCount, String seller, String sellNum, int status) {
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

    @Override
    public String toString() {
        return "Prod{" +
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
