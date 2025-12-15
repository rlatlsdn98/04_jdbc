package com.mycompany.section03.delete;

import com.mycompany.section03.delete.MenuRepository;

import java.sql.Connection;

import static com.mycompany.common.JDBCTemplate.*;

public class MenuService {
  public int removeMenu(int menuCode){

    Connection con = getConnection();
    MenuRepository menuRepository = new MenuRepository();

    int result = menuRepository.removeMenu(con,menuCode);

    if (result > 0) commit(con);
    else rollback(con);

    return result;
  }
}
