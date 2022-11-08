package org.example.overview.members.dao;

import org.example.overview.members.dto.Password;
import org.example.overview.members.entity.Prod;

public class ProdDAOTest {
    private ProdDAO prodDAO = new ProdDAO();

    public void addMembers() {
        int res = prodDAO.deleteAll();

        int cnt = 0;
        int year = 2010;
        int month = 1;
        int day = 1;
        for (int i = 'a'; i <= 'z'; i++) {
            prodDAO.insert(new Prod(
                    Character.toString(i) + "_uId",
                    String.valueOf(cnt),
                    year + "-" + month + "-" + day,
                    Character.toString(i) + "_manuf",
                    Character.toString(i) + "_info",
                    cnt + "_cost",
                    String.valueOf(cnt),
                    Character.toString(i) + "_sller",
                    cnt + "_sellNum",
                    String.valueOf(cnt),
                    String.valueOf(cnt)
                    ));
            year++;
            month++;
            day++;
            if(month == 12) month = 1;
            if(day == 31) day = 1;
        }
        prodDAO.selectAll().stream().forEach(m -> System.out.println(m));
    }
    public static void main(String[] args) {
        new ProdDAOTest().addMembers();
    }
}
