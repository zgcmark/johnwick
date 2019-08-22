package com.peppa.wick.api;

import com.peppa.wick.api.exception.WickException;
import com.peppa.wick.core.model.Instance;

import java.util.List;

/**
 * @author zhengguangchen
 */


public interface AppService {



    void registerInstance(String serverName, String ip, int port) throws WickException;


    List<Instance> getAllInstances(String serviceName) throws WickException;



}
