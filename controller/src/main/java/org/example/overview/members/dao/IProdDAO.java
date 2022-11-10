package org.example.overview.members.dao;

import org.example.overview.members.entity.Prod;

import java.util.List;

public interface IProdDAO {

    List<Prod> selectAll(String uId);

    Prod select(String uId);

    List<Prod> selectDate(String uId, String start, String end);

    int insert(Prod prod);

    int delete(String oId);

    int deleteAll(String uId);
}
