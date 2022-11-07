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
import java.util.stream.Collectors;

@Repository
public class ProdDAO implements IProdDAO {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String PROD_SELECT_ALL = "select * from PROD where USER_ID like ?";
    private static final String PROD_SEARCH_DATE = "select * from PROD where ORDER_DATE between cast(? as DATE) and cast(? as DATE)";
    private static final String PROD_SELECT = "select * from PROD where ORDER_NO = ?";
    private static final String PROD_DELETE = "delete PROD where ORDER_NO = ?";
    private static final String PROD_DELETE_ALL = "delete PROD";


    //private static final String PROD_INSERT = "insert into member values(?, ?, ?)";
    //private static final String MEMBER_PASSWORD_UPDATE = "update member set uPw = ? where uId = ?";
//    public MemberDAO () {
//        System.out.println("MemberDAO()");
//    }

//    public static MemberDAO getInstance() {
//        if (memberDAO == null) {
//            memberDAO = new MemberDAO();
//        }
//        return memberDAO;
//    }

    @Override
    public List<Prod> selectAll(String uid) {
        // 해당 ID에 해당되는 모든 상품정보 LOAD
        // List<Member> memberList = new LinkedList<>();
        // Prod entity 완성 후 작업
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_SELECT_ALL);
            stmt.setString(1, "%" + uid + "%");
            //stmt.setString(2, "%" + q + "%");

            rs = stmt.executeQuery();
            while (rs.next()) {
                //String mId = rs.getString("uId");
                //String uPw = rs.getString("uPw");
                //String uEmail = rs.getString("uEmail");
                //memberList.add(new Member(mId, uPw, uEmail));
                // Prod entity 완성 후 작업
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }

        return prodList;
    }

    @Override
    public Prod select(String pNo) {
        // 특정상품 선택 => 상세페이지로 접근시
        // Prod prod = null;
        // Prod entity 완성 후 작업
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_SELECT);
            stmt.setString(1, pNo);

            rs = stmt.executeQuery();

            if (rs.next()) {
                /*
                String mId = rs.getString("uId");
                String mPw = rs.getString("uPw");
                String mEmail = rs.getString("uEmail");
                member = new Member(mId, mPw, mEmail);
                Prod entity 완성 후 작업
                 */
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return prod;
    }

    @Override
    public List<Prod> selectDate(String start, String end) {
        // 날짜로 검색한 데이터결과
        // 해당 ID에 해당되는 모든 상품정보 LOAD
        // List<Prod> prodList = new LinkedList<>();
        // Prod entity 완성 후 작업
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_SEARCH_DATE);
            stmt.setString(1, start);
            stmt.setString(2, end);

            rs = stmt.executeQuery();
            while (rs.next()) {
                //String mId = rs.getString("uId");
                //String uPw = rs.getString("uPw");
                //String uEmail = rs.getString("uEmail");
                //memberList.add(new Member(mId, uPw, uEmail));
                // Prod entity 완성 후 작업
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return prodList;
    }

    @Override
    public int delete(String pNo) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_DELETE);
            stmt.setString(1, pNo);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int deleteAll() {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_DELETE_ALL);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

/*
    @Override
    public int insert(Member member) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_INSERT);
            stmt.setString(1, member.getuId());
            stmt.setString(2, member.getuPw());
            stmt.setString(3, member.getuEmail());
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int insertAll(List<Member> members) {
        return members.stream().map(m -> insert(m)).collect(Collectors.toList()).stream().reduce((x, y) -> x + y).orElse(0);
    }
    @Override
    public int update(String uId, String uPw) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(MEMBER_PASSWORD_UPDATE);
            stmt.setString(1, uPw);
            stmt.setString(2, uId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }
 */
}

