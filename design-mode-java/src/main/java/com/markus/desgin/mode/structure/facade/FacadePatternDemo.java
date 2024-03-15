package com.markus.desgin.mode.structure.facade;

/**
 * @Author: zhangchenglong06
 * @Date: 2024/3/15
 * @Description:
 */
public class FacadePatternDemo {
  /**
   * 门面模式在 Spring 中的应用:
   *  org.springframework.web.servlet.DispatcherServlet
   *  org.springframework.jdbc.core.JdbcTemplate
   * @param args
   */
  public static void main(String[] args) {
    RestaurantFacade facade = new RestaurantFacade();
    facade.eat("糖醋排骨");
  }
}
