package org.example.overview.members.service;

import org.example.overview.members.dao.ProdDAO;
import org.example.overview.members.dto.ProdDTO;
import org.example.overview.members.entity.Prod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdService implements IProdService {

    private ProdDAO prodDAO;

    @Autowired
    public ProdService(ProdDAO prodDAO) {
        this.prodDAO = prodDAO;
    }

    @Override
    public List<ProdDTO> getProdlistByDate(String uId, String start, String end) {
        if (start == null || end == null || uId == null) return null;

        List<Prod> prodList = prodDAO.selectDate(uId, start, end);

        return prodList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }

    @Override
    public ProdDTO getProdByOrderNo(String oId) {
        if (oId == null) return null;

        Prod prod = prodDAO.select(oId);
        if (prod == null) {
            return new ProdDTO();
        }
        return prod.toDTO();
    }

    @Override
    public List<ProdDTO> getAllProds(String uId) {
        if (uId == null) return null;

        List<Prod> prodList = prodDAO.selectAll(uId);

        return prodList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }

    @Override
    public boolean removeProdByOrderNo(String oId) {
        if (oId == null) return false;

        Prod prod = prodDAO.select(oId);
        if (prod == null) return false;

        int res = prodDAO.delete(oId);

        return res > 0;
    }

    @Override
    public boolean removeProds(String uId) {
        int res = prodDAO.deleteAll(uId);

        return res > 0;
    }
}
