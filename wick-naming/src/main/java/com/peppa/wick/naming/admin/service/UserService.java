package com.peppa.wick.naming.admin.service;

import com.peppa.wick.naming.admin.domain.User;

/**
 * @Author: DM
 * @Date: 2019-8-30$ 15:28$
 * @Description: $
 */
public interface UserService {

     void save(User user);

     void update(User user);

     void remove(String  id);

}
