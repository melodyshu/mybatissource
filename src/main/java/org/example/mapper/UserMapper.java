package org.example.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.example.domain.User;

/**
 * @Author: huangzhimao
 * @Date: 2020-06-05
 * @Description:
 */
public interface UserMapper {

  List<User> selectList();

  @Select("select name,address from tbs_user")
  @Results(id="userResultx",value = {
      @Result(property = "namex",column = "name"),
      @Result(property = "addressx",column = "address")
  })
  List<User> selectAll();

  List<User> selectList2(Map<String, String> map);

  @SelectProvider(type = SqlProvider.class,method = "selectName")
  List<User> selectByName(String name);

  public static class SqlProvider {
      public static String selectName() {
        return "SELECT name, address FROM tbs_user WHERE name = #{name}";
      }
    }
}
