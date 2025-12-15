package com.mycompany.section02.update;

import java.util.Scanner;

// 프로그램 실행 순서
/* Application -> MenuService -> MenuRepository */
/* Test Driven Programming 할 때 작은거부터 역으로 만듬 */
/* Application <- MenuService <- MenuRepository */
//   클래스간 데이터 이동 : Menu
public class Application {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("변경할 메뉴 번호 : ");
    int menuCode = sc.nextInt();
    System.out.print("변경할 메뉴 이름 : ");
    sc.nextLine();
    String menuName = sc.nextLine();
    System.out.print("변경할 메뉴 가격 : ");
    int menuPrice = sc.nextInt();

    Menu modifyMenu = new Menu(menuCode, menuName, menuPrice);
    MenuService menuService = new MenuService();
    int result = menuService.modifyMenu(modifyMenu);

    if (result > 0){
      System.out.println(menuCode + "번 메뉴가 수정되었습니다");
    }
    else{
      System.out.println("메뉴 코드가 잘못 입력되었습니다.");
    }

  }
}
