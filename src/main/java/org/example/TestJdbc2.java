package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: huangzhimao
 * @Date: 2020-06-02
 * @Description:
 */
public class TestJdbc2 {

  public static void main(String[] args) throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("开始连接JDBC...");
    String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT-8";
    String username="root";
    String password="123456";
    Connection conn = DriverManager.getConnection(url,username,password);
    System.out.println("成功连接JDBC...");
    String sql="select name,address from tbs_user where name=? and address=?";
    Statement stmt = conn.prepareStatement(sql);
    PreparedStatement ps = (PreparedStatement) stmt;
    ps.setString(1,"张三");
    ps.setString(2,"湖北");
    ps.execute();
    ResultSet resultSet = ps.getResultSet();
    while(resultSet.next()){
      String name = resultSet.getString(1);
      String address = resultSet.getString(2);
      System.out.println(name+"=="+address);
    }
    System.out.println("====");
  }
}
