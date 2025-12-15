package com.my.section02.update;

import java.sql.Connection;

import static com.my.common.JDBCTemplate.*;

// !! 백엔드개발자에게 가장 중요한 계층 !!
/* Service 계층
* - 비즈니스 로직(데이터 가공, 트랜잭션 처리, Repository호출)을 담당하는 계층
* */
public class MenuService {

  public int modifyMenu(Menu modifyMenu){
    Connection con = getConnection();

    // 설계도 -> 인스턴스화
    MenuRepository menuRepository = new MenuRepository();

    // repository 메서드를 호출하여 결과(1: 성공, 0: 실패) 반환받기
    int result = menuRepository.updateMenu(con, modifyMenu);

    if(result > 0) commit(con);
    else rollback(con);

    return result;
  }

}
