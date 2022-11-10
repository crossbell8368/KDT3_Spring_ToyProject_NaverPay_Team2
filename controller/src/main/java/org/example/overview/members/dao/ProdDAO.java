package org.example.overview.members.dao;

import org.example.overview.members.database.JDBCMgr;
import org.example.overview.members.entity.Prod;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ProdDAO implements IProdDAO {

    // Class Member =====================================================
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // SQL =====================================================
    private static final String PROD_SELECT_ALL = "select * from Prod where uId = ?";
    private static final String PROD_SELECT = "select * from Prod where oId = ?";
    private static final String PROD_SEARCH_DATE = "select * from Prod where orderDate between cast(? as DATE) and cast(? as DATE)";
    private static final String PROD_INSERT = "insert into Prod values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String PROD_DELETE = "delete Prod where oId = ?";
    private static final String PROD_DELETE_ALL = "delete Prod where uId = ?";

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
                        rs.getString("oId"),
                        rs.getString("uId"),
                        rs.getString("orderDate"),
                        rs.getString("productName"),
                        rs.getString("amount"),
                        rs.getString("status"),
                        rs.getString("company"),
                        rs.getString("companyTel")
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
                        rs.getString("oId"),
                        rs.getString("uId"),
                        rs.getString("orderDate"),
                        rs.getString("productName"),
                        rs.getString("amount"),
                        rs.getString("status"),
                        rs.getString("company"),
                        rs.getString("companyTel")
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
        // 날짜로 검색한 데이터결과 : YYYY-MM-DD 형태로 입력필요
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
                            rs.getString("oId"),
                            rs.getString("uId"),
                            rs.getString("orderDate"),
                            rs.getString("productName"),
                            rs.getString("amount"),
                            rs.getString("status"),
                            rs.getString("company"),
                            rs.getString("companyTel")
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
            stmt.setString(1, prod.getoId());
            stmt.setString(2, prod.getuId());
            stmt.setString(3, prod.getOrderDate());
            stmt.setString(1, prod.getProductName());
            stmt.setString(2, prod.getAmount());
            stmt.setString(3, prod.getStatus());
            stmt.setString(1, prod.getCompany());
            stmt.setString(2, prod.getCompanyTel());
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

