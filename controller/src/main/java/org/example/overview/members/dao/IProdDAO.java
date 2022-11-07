package org.example.overview.members.dao;

import org.example.overview.members.entity.Member;
import org.example.overview.members.entity.Prod;

import java.util.List;

public interface IProdDAO {
    List<Prod> search(String uId);
    Prod select(String uId);
    List<Prod> selectDate(String start, String end);
    List<Prod> selectAll();
    int insert(Prod prod);
    int delete(String pNo);
    int deleteAll();
}
