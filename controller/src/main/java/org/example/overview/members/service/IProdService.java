package org.example.overview.members.service;

import org.example.overview.members.dto.ProdDTO;

import java.util.List;

public interface IProdService {

    List<ProdDTO> getProdlistByDate(String uId, String start, String end);

    ProdDTO getProdByOrderNo(String oId);

    List<ProdDTO> getAllProds(String uId);

    boolean removeProdByOrderNo(String oId);

    boolean removeProds(String uId);

}
