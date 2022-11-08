package org.example.overview.members.DAO;

import org.example.overview.members.Entity.Payment;
import org.example.overview.members.database.ConnectionPoolMgr;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class PaymentDAO implements IPaymentDAO{

    private ConnectionPoolMgr connectionPoolMgr;
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String PAYMENT_SELECT = "select * from payment where oId = ? and mId = ?";
    private static final String PAYMENT_DELETE = "delete payment where oId = ?";

    public PaymentDAO(){
        if(connectionPoolMgr == null){
            connectionPoolMgr = ConnectionPoolMgr.getInstance();
        }
    }
    @Override
    public Payment select(String Id, String userid) {
        Payment payment = null;

        try {
            conn = connectionPoolMgr.getConnection();
            stmt = conn.prepareStatement(PAYMENT_SELECT);
            stmt.setString(1,Id);
            stmt.setString(2,userid);

            rs = stmt.executeQuery();

            if(rs.next()){
                String oId = rs.getString("oId");
                String uId = rs.getString("mId");
                String type = rs.getString("type");
                String time = rs.getString("time");
                String amount = rs.getString("amount");
                String get_npoint = rs.getString("get_npoint");
                String use_npoint = rs.getString("use_npoint");
                payment = new Payment(oId, uId, type,time, amount, get_npoint, use_npoint);
            }
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPoolMgr.freeConnection(conn,stmt,rs);
        }
        return payment;
    }

    @Override
    public int delete(String id) {
        int res = 0;
        try{
            conn = connectionPoolMgr.getConnection();
            stmt = conn.prepareStatement(PAYMENT_DELETE);
            stmt.setString(1,id);
            res = stmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connectionPoolMgr.freeConnection(conn,stmt,rs);
        }
        return res;
    }

    public static void main(String[] args) {
        PaymentDAO a = new PaymentDAO();
        System.out.println(a.select("FD1001","a"));
        System.out.println(a.delete("FD1002"));
    }
}
