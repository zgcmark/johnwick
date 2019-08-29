package com.peppa.wick.client.tranport;

import com.peppa.wick.api.exception.WickException;
import com.peppa.wick.core.model.Instance;
import com.peppa.wick.core.utils.CollectionUtils;
import sun.net.www.http.HttpClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * @author zhengguangchen
 * 与naming 服务端的通讯细节
 */
public class ServerProxy {
    private List<String> serverList;
    private List<String> usefulServerList;
    private Boolean instanceIsolation;
    private Properties properties;
    private TransportProxy transportProxy;

    public ServerProxy(List<String> serverList, Boolean instanceIsolation, Properties properties) {
        this.serverList=serverList;
        this.instanceIsolation=instanceIsolation;
        //TODO there may has more
        this.transportProxy=new HttpTransport();
        initRefresRealServer();
    }

    //异步线程单独的刷新，请求地址,因为可能填入的服务地址中有些已经不能访问了
    private void initRefresRealServer() {
    //TODO 异步刷新最新请求地址服务线程服务
        if (CollectionUtils.isEmpty(serverList)){
              throw new WickException(-1005,"server list is null ,can not start");
        }
        if (serverList.size()==1){
            usefulServerList=serverList;
            return;
        }

        usefulServerList=getUsefulServerList(serverList);


    }


    private List<String> getUsefulServerList(List<String> serverList) {
        Random random = new Random(System.currentTimeMillis());
        int index = random.nextInt(serverList.size());

        for (int i = 0; i < serverList.size(); i++) {
            String serverAddress = serverList.get(index);
            try {
                return transportProxy.getServerList(serverAddress);
            } catch (WickException e) {
//                throw new WickException(e);
            } catch (Exception e) {
            }
            index = (index + 1) % serverList.size();
        }


        return null;
    }


    public void registerApp(String serverName, Instance instance) {
        //等我调研完raft就开始写这个

    }
}
