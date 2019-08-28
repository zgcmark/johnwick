package com.peppa.wick.client.tranport;

import com.peppa.wick.core.model.Instance;

import java.util.List;

/**
 * @author zhengguangchen
 * 与naming 服务端的通讯细节
 */
public class ServerProxy {


    public ServerProxy(List<String> serverList, Boolean instanceIsolation) {

    }


    public void registerApp(String serverName, Instance instance) {
        //等我调研完raft就开始写这个

    }
}
