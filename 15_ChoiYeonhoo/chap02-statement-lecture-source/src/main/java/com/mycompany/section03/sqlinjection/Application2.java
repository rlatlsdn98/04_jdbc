package com.mycompany.section03.sqlinjection;

import java.sql.*;

import static com.mycompany.common.JDBCTemplate.close;
import static com.mycompany.common.JDBCTemplate.getConnection;

public class Application2 {
  public static void main(String[] args) {

    Connection con = null; // DB 연결 객체
//    Statement stmt = null; // SQL 전달 후 수행 결과 받아오는 객체
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    try {
      con = getConnection();

//      stmt = con.createStatement();
      int menuCode = 16;
      String menuName = "' or 1=1 and menu_code = '2";

      String sql
          = "select * from tbl_menu where menu_code = ?"
          + " and menu_name = ?";

      pstmt = con.prepareStatement(sql);

      pstmt.setInt(1, menuCode);
      pstmt.setString(2, menuName);

      // select * from tbl_menu
      // where menu_code = 16 and menu_name = '\' or 1=1 and menu_code = \'2'

      rset = pstmt.executeQuery();

      while(rset.next()){

        System.out.println("menu_code : " + rset.getInt("menu_code"));
        System.out.println("menu_name : " + rset.getString("menu_name"));
        System.out.println("menu_price : " + rset.getInt("menu_price"));
        System.out.println("category_code : " + rset.getInt("category_code"));
        System.out.println("orderable_status : " + rset.getString("orderable_status"));
        System.out.println("=======================================================================");
      }

    }
    catch (SQLException e){
      throw new RuntimeException(e);
    }
    finally {
      close(rset);
      close(pstmt);
      close(con);

    }
  }
}
