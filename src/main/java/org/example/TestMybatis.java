package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.User;

/**
 * @Author: huangzhimao
 * @Date: 2020-05-31
 */
public class TestMybatis {

  /**
   * 传统方式调用
   * @throws Exception
   */
  public void testStatement() throws Exception {
    //1.读取配置文件,还未解析
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    //2.解析配置文件为Configuration,并创建defaultSqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //3.创建defaultSqlSession对象,设置事务不自动提交,完成Executor对象创建
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //4.根据statementId从Configuration中的map中获取MappedStatement对象
    //将查询操作交给executor执行器
    List<User> userList = sqlSession.selectList("namespacetest.selectList");

    System.out.println(userList);

  }
}
