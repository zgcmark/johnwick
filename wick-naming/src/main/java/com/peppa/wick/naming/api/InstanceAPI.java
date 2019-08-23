package com.peppa.wick.naming.api;

import com.peppa.wick.common.WickUrlContext;
import com.peppa.wick.common.net.Response;
import com.peppa.wick.naming.appserver.AppServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhengguangchen
 */

@RestController
@RequestMapping(WickUrlContext.REQUEST_URL_V1_PRIX+"/instance")
public class InstanceAPI {

    @Autowired
    private AppServerService appServerService;




    //注册接口
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Response<Integer> register(HttpServletRequest request) throws Exception {

        return new Response().success();
    }


    //renew
    @RequestMapping(value = "renew", method = RequestMethod.PUT)
    public Response<Integer> renew(HttpServletRequest request) throws Exception {

        return new Response().success();
    }


    //移除节点
    @RequestMapping(value = "remove", method = RequestMethod.DELETE)
    public Response<Integer> remove(HttpServletRequest request) throws Exception {

        return new Response().success();
    }

    //隔离节点
    @RequestMapping(value = "isolation", method = RequestMethod.POST)
    public Response<Integer> isolation(HttpServletRequest request) throws Exception {

        return new Response().success();
    }



    //抑制节点
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Response<Integer> getAllInstance(HttpServletRequest request) throws Exception {

        return new Response().success();
    }




}
