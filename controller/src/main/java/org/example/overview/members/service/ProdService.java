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
    public List<ProdDTO> listByDate(String uid, String start, String end) {
        if (start == null || end == null) return null;

        List<Prod> prodList = prodDAO.selectDate(uid, start, end);
        return prodList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }


    @Override
    public ProdDTO getByOrderNo(String pNo) {
        if (pNo == null) return null;

        Prod prod = prodDAO.select(pNo);
        return prod.toDTO();
    }

    @Override
    public List<ProdDTO> getAllProds() {
        List<Prod> prodList = prodDAO.selectAll();
        return prodList.stream().map(m -> m.toDTO()).collect(Collectors.toList());
    }


    @Override
    public boolean removeByOrderNo(String pNo) {
        if (pNo == null) return false;

        Prod prod = prodDAO.select(pNo);
        if (prod == null) return false;

        int res = prodDAO.delete(pNo);
        return res > 0;
    }

    @Override
    public boolean removeProds() {
        int res = prodDAO.deleteAll();
        return res > 0;
    }
}