package org.example.overview.members.database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDriverTest {
    public static void main(String[] args) {
        String driver = "org.h2.Driver";
        String url = "jdbc:h2:~/NaverPayTeam2";
        String user = "sa";
        String password = "";

        try {
            Class.forName(driver);
            System.out.println("... JDBC Driver 로딩 성공!");

            DriverManager.getConnection(url, user, password);
            System.out.println("... H2 DB 연결 성공!");
        } catch (ClassNotFoundException e) {
            System.out.println("[ ClassNotFoundException ] JDBC Driver 로딩 실패!");
        } catch (SQLException e) {
            System.out.println("[ SQLException ] H2 DB 연결 실패!");
        } catch (Exception e) {
            System.out.println("[ Exception ] 예외 발생!");
        }
    }
}
