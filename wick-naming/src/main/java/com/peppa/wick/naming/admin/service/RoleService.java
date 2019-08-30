package com.peppa.wick.naming.admin.service;

import com.peppa.wick.naming.admin.domain.Role;
import com.peppa.wick.naming.admin.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @Author: DM
 * @Date: 2019-8-30$ 15:28$
 * @Description: $
 */
@Service
@Validated
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public void save(@Valid Role role) {

        role.setId(UUID.randomUUID().toString());
        roleMapper.save(role);
    }

    public void update(@Valid Role role) {

        roleMapper.update(role);
    }
    public void remove(@Valid String  id) {

        roleMapper.remove(id);
    }

}
