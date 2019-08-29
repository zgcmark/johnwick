package com.peppa.wick.client.tranport;

import com.peppa.wick.core.utils.HttpClientService;
import sun.net.www.http.HttpClient;

import java.util.List;

/**
 * @author zhengguangchen
 */


public class HttpTransport implements  TransportProxy {



    @Override
    public List<String> getServerList(String serverAddress) {
        //TODO to naming get server list;
//        HttpClientService.sendGet();
        return null;
    }
}
