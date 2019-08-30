package com.peppa.wick.naming.admin.mapper;

import com.peppa.wick.naming.admin.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: DM
 * @Date: 2019-8-30$ 15:38$
 * @Description: $
 */
@Mapper
public interface PermissionMapper {

    int save(Permission permission);

    int update(Permission permission);

    int remove(@Param("id") String id);

    Permission getById(@Param("id") String id);
}
