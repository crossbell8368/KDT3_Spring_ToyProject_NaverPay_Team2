package org.example.overview.members.service;

import org.example.overview.members.dto.ProdDTO;

import java.util.List;

public interface IProdService {

    /*
    boolean autoLogin(String autoLogin, String cookieId);
    MemberDTO login(String uId);
    MemberDTO login(String uId, String uPw);
    boolean signup(String uId, String uPw, String uEmail);
    boolean updateUserPassword(String uId, Password uPw, Password uNewPw);
     */

    List<ProdDTO> getProdlistByDate(String uId, String start, String end);

    ProdDTO getProdByOrderNo(String oId);

    List<ProdDTO> getAllProds(String uId);

    boolean removeProdByOrderNo(String oId);

    boolean removeProds(String uId);

}
