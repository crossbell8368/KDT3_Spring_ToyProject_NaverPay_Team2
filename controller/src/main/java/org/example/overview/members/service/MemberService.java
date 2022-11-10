package org.example.overview.members.service;

import org.example.overview.members.dao.MemberDAO;
import org.example.overview.members.dto.MemberDTO;
import org.example.overview.members.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements IMemberService {

    private MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public MemberDTO login(String inputId, String inputPw) {
        MemberDTO memberDTO = new MemberDTO(inputId, inputPw);
        if (memberDTO.getuPw() == null) return null;

        Member member = memberDAO.select(memberDTO.getuId());
        if (member == null || member.getuPw() == null) return null;
        if (member.getuPw().equals(memberDTO.getuPw())) {
            return memberDTO;
        }
        return null;
    }

    @Override
    public MemberDTO findUserByuId(String inputId) {
        if (inputId == null) return null;

        Member member = memberDAO.select(inputId);
        if (member == null) return null;

        return member.toDTO();
    }
}
