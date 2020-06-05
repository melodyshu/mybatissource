package org.example.mapper;

import java.util.List;
import java.util.Map;
import org.example.domain.User;

/**
 * @Author: huangzhimao
 * @Date: 2020-06-05
 * @Description:
 */
public interface UserMapper {

  List<User> selectList();

  List<User> selectList2(Map<String, String> map);
}
