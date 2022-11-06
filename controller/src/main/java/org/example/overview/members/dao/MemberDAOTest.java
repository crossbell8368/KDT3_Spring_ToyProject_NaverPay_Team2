package org.example.overview.members.dao;

import org.example.overview.members.entity.Member;

public class MemberDAOTest {
    public static void main(String[] args) {

        MemberDAO memberDAO = new MemberDAO();
        for (int i = 'a'; i <= 'f'; i++) {
            String alpha = Character.toString(i);
            memberDAO.insert(new Member(alpha, alpha + "1234",
                    alpha + "@gmail.com", "010-0000-000" + (i - 97)));
        }
        memberDAO.selectAll().stream().forEach(members -> System.out.println(members));
    }
}
