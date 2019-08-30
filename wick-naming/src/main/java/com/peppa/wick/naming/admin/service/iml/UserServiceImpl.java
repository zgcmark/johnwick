package com.peppa.wick.naming.admin.service.iml;

import com.peppa.wick.naming.admin.domain.User;
import com.peppa.wick.naming.admin.mapper.UserMapper;
import com.peppa.wick.naming.admin.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.UUID;

/**
 * @Author: DM
 * @Date: 2019-8-30$ 15:28$
 * @Description: $
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public void save(@Valid User user) {

        user.setId(UUID.randomUUID().toString());
        userMapper.save(user);
    }

    public void update(@Valid User user) {

        userMapper.update(user);
    }
    public void remove(@Valid String  id) {

        userMapper.remove(id);
    }

}
