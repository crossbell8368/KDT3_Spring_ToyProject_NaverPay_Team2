package org.example.overview.members.vo;

import java.util.Objects;

public class MemberVO {

    private String uId = "";
    private String uPw = "";
    private String uEmail = "";
    private String uPhoneNumber = "";

    public MemberVO() {
    }

    public MemberVO(String uId, String uPw, String uEmail, String uPhoneNumber) {
        this.uId = uId;
        this.uPw = uPw;
        this.uEmail = uEmail;
        this.uPhoneNumber = uPhoneNumber;
    }

    public String getuId() {
        return uId;
    }

    public String getuPw() {
        return uPw;
    }

    public String getuEmail() {
        return uEmail;
    }

    public String getuPhoneNumber() {
        return uPhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberVO memberVO = (MemberVO) o;
        return uId.equals(memberVO.uId) && uPw.equals(memberVO.uPw) && uEmail.equals(memberVO.uEmail) && Objects.equals(uPhoneNumber, memberVO.uPhoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, uPw, uEmail, uPhoneNumber);
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "uId='" + uId + '\'' +
                ", uPw='" + uPw + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uPhoneNumber='" + uPhoneNumber + '\'' +
                '}';
    }
}
