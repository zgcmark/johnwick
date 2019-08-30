package com.peppa.wick.naming.admin.service;

import com.peppa.wick.naming.admin.domain.User;

import javax.validation.Valid;

/**
 * @Author: DM
 * @Date: 2019-8-30$ 15:28$
 * @Description: $
 */
public interface UserService {

     void save(@Valid User user);

     void update(@Valid User user);

     void remove(@Valid String  id);

}
