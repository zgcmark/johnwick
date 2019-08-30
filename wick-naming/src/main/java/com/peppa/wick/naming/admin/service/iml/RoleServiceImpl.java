package com.peppa.wick.naming.admin.service.iml;

import com.peppa.wick.naming.admin.domain.Role;
import com.peppa.wick.naming.admin.mapper.RoleMapper;
import com.peppa.wick.naming.admin.service.RoleService;
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
@Validated
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
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
