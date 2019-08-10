package com.peppa.wick.naming.api;

import com.peppa.wick.naming.service.AppServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengguangchen
 */

@RestController
public class InstanceAPI {

    @Autowired
    private AppServerService appServerService;





}
