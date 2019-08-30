package com.peppa.wick.naming.admin.service;

import com.peppa.wick.naming.admin.domain.Permission;
import com.peppa.wick.naming.admin.mapper.PermissionMapper;
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
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    public void save(@Valid Permission permission) {

        permission.setId(UUID.randomUUID().toString());
        permissionMapper.save(permission);
    }

    public void update(@Valid Permission permission) {

        permissionMapper.update(permission);
    }
    public void remove(@Valid String  id) {

        permissionMapper.remove(id);
    }

}
