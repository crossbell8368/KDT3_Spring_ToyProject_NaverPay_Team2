package org.example.overview.members.service;

import org.example.overview.members.dto.MemberDTO;

public interface IMemberService {

    MemberDTO login(String uId, String uPw);

    MemberDTO findUserByuId(String uId);
}
