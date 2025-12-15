package com.ohgiraffers.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/* 반복되는 JDBC 관련 코드를 미리 작성해서 Util용으로 사용할
  JDBCTemplate 클래스를 만들 수 있다.*/
public class JDBCTemplate {

  public static Connection getConnection(){

    Properties prop = new Properties();
    Connection con = null;

    try{
      prop.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));

      // properties 파일에서 읽어온 데이터를 Key를 통해 얻어옴
      String url = prop.getProperty("url");
      String user = prop.getProperty("user");
      String password = prop.getProperty("password");

      con = DriverManager.getConnection(url, user, password);

    }catch (SQLException e){
      e.printStackTrace();
    }catch (IOException e){
      e.printStackTrace();
    }

    return con;
  }



}
