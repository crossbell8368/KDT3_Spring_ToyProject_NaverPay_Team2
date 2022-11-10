package org.example.overview.members.dao;

import org.example.overview.members.entity.Member;

import java.util.List;

public interface IMemberDAO {

    Member select(String uId);

    List<Member> selectAll();

    int insert(Member member);
}
