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

    List<ProdDTO> listByDate(String uId, String start, String end);

    ProdDTO getByOrderNo(String pNo);

    List<ProdDTO> getAllProds();

    boolean removeByOrderNo(String pNo);

    boolean removeProds();

}
