package com.peppa.wick.client;

import com.peppa.wick.api.AppService;
import com.peppa.wick.api.exception.WickException;
import com.peppa.wick.client.heart.HeartInfo;
import com.peppa.wick.client.heart.HeartbeatManager;
import com.peppa.wick.client.tranport.ServerProxy;
import com.peppa.wick.config.constant.PropertiesConstant;
import com.peppa.wick.core.event.EventDispatcher;
import com.peppa.wick.core.model.Instance;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author zhengguangchen
 */

//客户端默认实现
public class DefaultClientAppService implements AppService {


    private String namespace="wick";

    private List<String> serverList;

    private String localCacheDir;


    private HeartbeatManager heartbeatManager;

    private ServerProxy serverProxy;

    private EventDispatcher eventDispatcher;





    public DefaultClientAppService(String serverListStr) {
        Properties properties = new Properties();
        properties.setProperty(PropertiesConstant.SERVER_ADDR,serverListStr);
        init(properties);
    }

    public DefaultClientAppService(Properties properties) {
        init(properties);

    }


    //初始化客户端配置
    private void init(Properties properties) {
        serverList=Arrays.asList(properties.getProperty(PropertiesConstant.SERVER_ADDR).split(","));

        initLocalCacheDir(properties);
        //load event check
        eventDispatcher=new EventDispatcher();
        //init ServerProxy
        String appIsolation = properties.getProperty(properties.getProperty(PropertiesConstant.APP_ISOLATION));
        Boolean instanceIsolation=false;
        if (StringUtils.isNotEmpty(appIsolation) && appIsolation.equals("true")){
            instanceIsolation=true;
        }
        serverProxy=new ServerProxy(serverList,instanceIsolation,properties);
        //TODO 服务访问代理内容


    }



    //初始化本地缓存
    private void initLocalCacheDir(Properties properties) {
    if (StringUtils.isNotEmpty(properties.getProperty(PropertiesConstant.CACHE_DIR))){
        localCacheDir=properties.getProperty(PropertiesConstant.CACHE_DIR);
    }else {
        localCacheDir = System.getProperty("user.home") + "/nacos/naming/" + namespace;

    }


    }





    @Override
    public void registerInstance(String serverName, String ip, int port) throws WickException {
        Instance instance = new Instance();
        instance.setIp(ip);
        instance.setPort(port);
        instance.setWeight(1);
        startRegister(serverName,instance);
    }


    @Override
    public List<Instance> getAllInstances(String serviceName) throws WickException {

        return null;
    }


    private void startRegister(String serverName, Instance instance) {
    //need first add heart
        if (instance.isEnabled()) {
            HeartInfo heartInfo = new HeartInfo();
            heartInfo.setIp(instance.getIp());
            heartInfo.setAppName(instance.getAppName());
            heartInfo.setPort(instance.getPort());
            heartInfo.setWeight(instance.getWeight());
            heartbeatManager.addHeartInfo(serverName, heartInfo);
            serverProxy.registerApp(serverName,instance);
        }
        //no sth to do
    }
}
