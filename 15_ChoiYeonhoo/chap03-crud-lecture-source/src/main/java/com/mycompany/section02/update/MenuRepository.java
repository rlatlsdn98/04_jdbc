package com.mycompany.section02.update;


/* Repository (저장소) 계층
* DBMS를 통해 수행할 CRUD 작업 단위의 메서드를 정의하는 계층
* */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import static com.mycompany.common.JDBCTemplate.close;

public class MenuRepository {

  public int updateMenu(Connection con, Menu modifyMenu){

    int result = 0; // 업데이트 결과 1 또는 0 저장할 변수

    PreparedStatement pstmt = null;
    Properties prop = new Properties(); // XML 읽어오기

    try {
      prop.loadFromXML(new FileInputStream("src/main/java/com/mycompany/mapper/MenuMapper.xml"));

      String sql = prop.getProperty("updateMenu");

      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, modifyMenu.getMenuName());
      pstmt.setInt(2,modifyMenu.getMenuPrice());
      pstmt.setInt(3,modifyMenu.getMenuCode());

      result = pstmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }finally {
      close(pstmt);
    }


    return result;
  }
}
