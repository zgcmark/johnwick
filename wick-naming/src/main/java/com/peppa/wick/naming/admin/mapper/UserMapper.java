package com.peppa.wick.naming.admin.mapper;

import com.peppa.wick.naming.admin.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: DM
 * @Date: 2019-8-30$ 14:55$
 * @Description: $
 */
@Mapper
public interface UserMapper {

    int save(User user);

    int update(User user);

    int remove(@Param("id") String id);

    User getById(@Param("id") String id);
}
