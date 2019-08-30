package com.peppa.wick.naming.admin.service;

import com.peppa.wick.naming.admin.domain.Permission;

/**
 * @Author: DM
 * @Date: 2019-8-30$ 15:28$
 * @Description: $
 */
public interface PermissionService {


     void save(Permission permission);

     void update(Permission permission);

     void remove(String  id);

}
