package com.my.section01.conncetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {
  public static void main(String[] args) {
    Connection con = null;

    try{
      /* Connection
      * - DB 연결 정보를 저장하고
      *   JAVA application과 DBMS를 연결해주는 객체
      *
      * 객체 생성 == 메모리 할당 == 메모리에 적재
      * DriverManager를 이용하여 Connection 객체 생성
      * */

      /* 하드코딩
      * 수정 시 컴파일 새로 해야함.
      * 보안 문제
      * Connection이용하는 파일마다 중복작성
      */
      con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306",
        "swcamp",
        "swcamp"
      );

      System.out.println("con = " + con);

    }catch(SQLException e){

      e.printStackTrace();

    }finally {

      try {

        con.close();

      } catch (SQLException e) {

        e.printStackTrace();

      }
    }
  }
}
