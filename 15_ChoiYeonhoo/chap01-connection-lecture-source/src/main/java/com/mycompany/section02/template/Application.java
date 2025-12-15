package com.mycompany.section02.template;

import java.sql.Connection;

/* JDBCTemplate 클래스 내 static 메서드 호출 시 클래스명을 생략할 수 있게 함. */
import static com.mycompany.section02.template.JDBCTemplate.*;

public class Application {

  public static void main(String[] args) {

    Connection con = null;

    try {
      con = getConnection();
      System.out.println("con = " + con);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally {
      close(con);
    }
  }
}
