package com.peppa.wick.client.tranport;

import com.peppa.wick.core.model.Instance;

import java.util.List;
import java.util.Properties;

/**
 * @author zhengguangchen
 * 与naming 服务端的通讯细节
 */
public class ServerProxy {
    private List<String> serverList;
    private Boolean instanceIsolation;
    private Properties properties;


    public ServerProxy(List<String> serverList, Boolean instanceIsolation, Properties properties) {
        this.serverList=serverList;
        this.instanceIsolation=instanceIsolation;

        initRefresRealServer();
    }

    //异步线程单独的刷新，请求地址,因为可能填入的服务地址中有些已经不能访问了
    private void initRefresRealServer() {
    //TODO 异步刷新最新请求地址服务线程服务
    }


    public void registerApp(String serverName, Instance instance) {
        //等我调研完raft就开始写这个

    }
}
