package com.peppa.wick.naming.admin.service;

import com.peppa.wick.naming.admin.domain.Role;

/**
 * @Author: DM
 * @Date: 2019-8-30$ 15:28$
 * @Description: $
 */
public interface RoleService {

    public void save(Role role);

    public void update(Role role);

    public void remove(String  id);

}
