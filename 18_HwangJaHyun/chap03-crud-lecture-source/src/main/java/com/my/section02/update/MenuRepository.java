package com.my.section02.update;
// 사용자 입장
//           DTO         DTO
// Application-> Service -> Repository
// 개발 순서
// DTO -> Repository -> Service -> Application
// TDD 방식

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import static com.my.common.JDBCTemplate.close;

/* Repository (저장소) 계층
* DBMS를 통해 수행할 CRUD 작업 단위의 메서드를 정의하는 계층
* */
public class MenuRepository {
  public int updateMenu(Connection con, Menu modifyMenu) {
    int result = 0; // 업데이트 결과 1 또는 0 저장할 변수
                    // 1 성공 0 실패

    PreparedStatement pstmt = null;
    Properties prop = new Properties(); // XML읽어오기

    try{
      prop.loadFromXML(new FileInputStream("src/main/java/com/my/mapper/MenuMapper.xml"));
      String sql = prop.getProperty("updateMenu");
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, modifyMenu.getMenuName());
      pstmt.setInt(2,  modifyMenu.getMenuPrice());
      pstmt.setInt(3,  modifyMenu.getMenuCode());

      result = pstmt.executeUpdate(); //Update수행

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      close(pstmt);
    }

    return result;
  }
}
