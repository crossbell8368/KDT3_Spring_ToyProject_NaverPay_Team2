package org.example.overview.members.entity;

import org.example.overview.members.dto.MemberDTO;

public class Member {

    private String uId = "";
    private String uPw = "";
    private String uEmail = "";
    private String uPhoneNumber = "";

    public Member() {
    }

    public Member(String uId, String uPw, String uEmail, String uPhoneNumber) {
        this.uId = uId;
        this.uPw = uPw;
        this.uEmail = uEmail;
        this.uPhoneNumber = uPhoneNumber;
    }

    public MemberDTO toDTO() {
        return new MemberDTO(uId, uPw, uEmail, uPhoneNumber);
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
    public String toString() {
        return "Member{" +
                "uId='" + uId + '\'' +
                ", uPw='" + uPw + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uPhoneNumber='" + uPhoneNumber + '\'' +
                '}';
    }
}
