package org.example.overview.members.vo;

public class DetailVO {
    ProdVO prodVO = new ProdVO();
    PaymentVO paymentVO = new PaymentVO();

    public DetailVO(ProdVO prodVO, PaymentVO paymentVO) {
        this.prodVO = prodVO;
        this.paymentVO = paymentVO;
    }

    public ProdVO getProdVO() {
        return prodVO;
    }

    public PaymentVO getPaymentVO() {
        return paymentVO;
    }

    @Override
    public String toString() {
        return "DetailVO{" +
                "prodVO=" + prodVO +
                ", paymentVO=" + paymentVO +
                '}';
    }
}
