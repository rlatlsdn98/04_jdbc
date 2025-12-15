package com.my.section02.template;

import java.sql.Connection;

/* JDBCTemplate 클래스 내 static 메서드 호출 시 클래스명을 생략할 수 있게 함*/
import static com.my.section02.template.JDBCTemplate.*;

/* properties 파일 내용을 읽어와 DB와 연결할 수 있다. */
public class Application {
  public static void main(String[] args) {

    Connection con = null;

    try{
      con = getConnection();

      //System.out.println("con = " + con);

    }catch(Exception e){
      e.printStackTrace();

    }finally{
      // finally를 쓰기 위해 try-catch문을 씀
      // try,catch,return여부에 상관없이 무조건 실행되는 코드
      close(con);
    }
  }
}
