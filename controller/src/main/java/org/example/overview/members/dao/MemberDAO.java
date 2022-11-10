package org.example.overview.members.dao;

import org.example.overview.members.database.JDBCMgr;
import org.example.overview.members.entity.Member;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class MemberDAO implements IMemberDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String MEMBER_SELECT = "select * from MEMBER where uId = ?";
    private static final String MEMBER_SELECT_ALL = "select * from MEMBER";
    private static final String MEMBER_INSERT = "insert into MEMBER values(?, ?, ?, ?)";

    @Override
    public Member select(String inputId) {
        Member member = null;

        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT);
            stmt.setString(1, inputId);

            rs = stmt.executeQuery();
            if (rs.next()) {
                String uId = rs.getString("uId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");
                String uPhoneNumber = rs.getString("uPhoneNumber");
                member = new Member(uId, uPw, uEmail, uPhoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return member;
    }

    @Override
    public List<Member> selectAll() {
        List<Member> members = new LinkedList<>();

        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_SELECT_ALL);

            rs = stmt.executeQuery();
            while (rs.next()) {
                String uId = rs.getString("uId");
                String uPw = rs.getString("uPw");
                String uEmail = rs.getString("uEmail");
                String uPhoneNumber = rs.getString("uPhoneNumber");
                members.add(new Member(uId, uPw, uEmail, uPhoneNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return members;
    }

    @Override
    public int insert(Member member) {
        int count = 0;

        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_INSERT);

            stmt.setString(1, member.getuId());
            stmt.setString(2, member.getuPw());
            stmt.setString(3, member.getuEmail());
            stmt.setString(4, member.getuPhoneNumber());
            count = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return count;
    }
}
