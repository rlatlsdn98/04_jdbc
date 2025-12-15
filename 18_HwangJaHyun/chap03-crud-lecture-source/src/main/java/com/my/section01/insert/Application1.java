package com.my.section01.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static com.my.common.JDBCTemplate.*;

/*
*
* */
public class Application1 {
  public static void main(String[] args) {
    String sql = "insert into tbl_menu" +
                 "(menu_name, menu_price, category_code, orderable_status) " +
                 "values(?, ?, ?, ?)";

    Connection con = null;
    PreparedStatement pstmt = null;
    int result = 0; // DML 수행 결과는 반영된 행의 개수(int)
    Scanner sc = new Scanner(System.in);

    System.out.print("추가할 메뉴 명: ");
    String menuName = sc.nextLine();

    System.out.print("메뉴 가격: ");
    int menuPrice = sc.nextInt();

    System.out.print("카테고리 코드: ");
    int categoryCode = sc.nextInt();
    sc.nextLine();

    System.out.print("주문 가능 여부(Y,N): ");
    String OrderableStatus = sc.nextLine().toUpperCase();

    try{
      // Connection 객체 생성, AutoCommit 비활성화(JDBCTemplate)
      con = getConnection();
      
      // preparedStatement 객체 생성
      pstmt = con.prepareStatement(sql);
      
      // placeholder에 알맞은 값 세팅
      pstmt.setString(1, menuName);
      pstmt.setInt(2, menuPrice);
      pstmt.setInt(3, categoryCode);
      pstmt.setString(4, OrderableStatus);
      
      // 실행 후 결과 반환 받기
      // -> executeUpdate() : DML 구문 수행 수 반영된 행의 개수 반환
      // DML(Date Manipulation Language)
      result = pstmt.executeUpdate();

      // 성공 여부에 따라 commit/rollback 지정
      if(result > 0) {
        System.out.println("메뉴 추가 성공");
        con.commit();
      }else{
        System.out.println("메뉴가 추가되지 않았습니다.");
        con.rollback();
      }
    }catch(SQLException e){
      throw new RuntimeException(e);
    }finally{
      close(pstmt);
      close(con);
    }
  }
}
