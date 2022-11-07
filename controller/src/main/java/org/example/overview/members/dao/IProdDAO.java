package org.example.overview.members.dao;

import org.example.overview.members.entity.Member;

import java.util.List;

public interface IProdDAO {

    List<Prod> selectAll(String uId);
    Prod select(String uId);
    List<Prod> selectDate(String start, String end);
    int delete(String pNo);
    int deleteAll();
}
