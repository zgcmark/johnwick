package com.peppa.wick.naming.admin.mapper;

import com.peppa.wick.naming.admin.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: DM
 * @Date: 2019-8-30$ 15:38$
 * @Description: $
 */
@Mapper
public interface RoleMapper {

    int save(Role role);

    int update(Role role);

    int remove(@Param("id") String id);

    Role getById(@Param("id") String id);
}
