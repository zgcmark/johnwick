package com.peppa.wick.naming.admin.service.iml;

import com.peppa.wick.naming.admin.domain.Permission;
import com.peppa.wick.naming.admin.mapper.PermissionMapper;
import com.peppa.wick.naming.admin.service.PermissionService;
import org.springframework.stereotype.Service;
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
public class PermissionServiceImpl implements PermissionService {

    @Resource
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
