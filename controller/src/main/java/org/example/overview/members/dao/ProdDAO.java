package org.example.overview.members.dao;

import org.example.overview.members.database.JDBCMgr;
import org.example.overview.members.entity.Member;
import org.example.overview.members.entity.Prod;
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

    // Class Member =====================================================
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // SQL =====================================================
    private static final String PROD_SELECT_ALL = "select * from PROD where uId = ?";
    private static final String PROD_SELECT = "select * from PROD where oId = ?";
    private static final String PROD_SEARCH_DATE = "select * from PROD where ORDER_DATE between cast(? as DATE) and cast(? as DATE)";
    private static final String PROD_INSERT = "insert into PROD values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String PROD_DELETE = "delete PROD where ORDER_NO = ?";
    private static final String PROD_DELETE_ALL = "delete PROD where USER_ID = ?";

    // Method =====================================================
    @Override
    public List<Prod> selectAll(String uId) {
        // 해당 ID에 해당되는 모든 상품정보 LOAD
        List<Prod> prodList = new LinkedList<>();
        // int cnt = 0;

        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_SELECT_ALL);
            stmt.setString(1, uId);

            rs = stmt.executeQuery();
            while (rs.next()) {
                prodList.add(new Prod(
                        rs.getString("uId"),
                        rs.getString("oId"),
                        rs.getString("ORDER_DATE"),
                        rs.getString("PROD_MANUF"),
                        rs.getString("PROD_INFO"),
                        rs.getString("PROD_COST"),
                        rs.getString("PROD_CNT"),
                        rs.getString("PROD_SELLER"),
                        rs.getString("PROD_SELLNUM"),
                        rs.getString("PROD_STATUS"),
                        rs.getString("PROD_REVIEW")
                ));
                // System.out.println(prodList.get(cnt).toString());
                // cnt++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }

        return prodList;
    }

    @Override
    public Prod select(String oId) {
        // 특정상품 선택 => 상세페이지로 접근시
        Prod prod = null;

        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_SELECT);
            stmt.setString(1, oId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                prod = new Prod(
                        rs.getString("uId"),
                        rs.getString("oId"),
                        rs.getString("ORDER_DATE"),
                        rs.getString("PROD_MANUF"),
                        rs.getString("PROD_INFO"),
                        rs.getString("PROD_COST"),
                        rs.getString("PROD_CNT"),
                        rs.getString("PROD_SELLER"),
                        rs.getString("PROD_SELLNUM"),
                        rs.getString("PROD_STATUS"),
                        rs.getString("PROD_REVIEW")
                );
                System.out.println(prod.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return prod;
    }

    @Override
    public List<Prod> selectDate(String uId, String start, String end) {
        // 날짜로 검색한 데이터결과
        // 해당 ID에 해당되는 모든 상품정보 LOAD
        List<Prod> prodList = new LinkedList<>();
        // int cnt = 0;

        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_SEARCH_DATE);
            stmt.setString(1, start);
            stmt.setString(2, end);

            rs = stmt.executeQuery();
            while (rs.next()) {
                if(rs.getString("uId").equals(uId)){
                    prodList.add(new Prod(
                            rs.getString("uId"),
                            rs.getString("oId"),
                            rs.getString("ORDER_DATE"),
                            rs.getString("PROD_MANUF"),
                            rs.getString("PROD_INFO"),
                            rs.getString("PROD_COST"),
                            rs.getString("PROD_CNT"),
                            rs.getString("PROD_SELLER"),
                            rs.getString("PROD_SELLNUM"),
                            rs.getString("PROD_STATUS"),
                            rs.getString("PROD_REVIEW")
                    ));
                    // System.out.println(prodList.get(cnt).toString());
                    // cnt++;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(rs, stmt, conn);
        }
        return prodList;
    }

    public int insert(Prod prod) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_INSERT);
            stmt.setString(1, prod.getuId());
            stmt.setString(2, prod.getOrderNo());
            stmt.setString(3, prod.getOrderDate());
            stmt.setString(1, prod.getManufacture());
            stmt.setString(2, prod.getProductInfo());
            stmt.setString(3, prod.getCost());
            stmt.setString(1, prod.getProductCount());
            stmt.setString(2, prod.getSeller());
            stmt.setString(3, prod.getSellNum());
            stmt.setString(1, prod.getStatus());
            stmt.setString(2, prod.getReview());
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int delete(String oId) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_DELETE);
            stmt.setString(1, oId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }

    @Override
    public int deleteAll(String uId) {
        int res = 0;
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(PROD_DELETE_ALL);
            stmt.setString(1, uId);
            res = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
        return res;
    }
}

