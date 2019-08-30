package com.peppa.wick.naming.admin.service;

import com.peppa.wick.naming.admin.domain.Permission;

/**
 * @Author: DM
 * @Date: 2019-8-30$ 15:28$
 * @Description: $
 */
public interface PermissionService {


    public void save(Permission permission);

    public void update(Permission permission);

    public void remove(String  id);

}
