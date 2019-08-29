package com.peppa.wick.client.tranport;

import java.util.List;

/**
 * @author zhengguangchen
 */


public interface TransportProxy {


    List<String> getServerList(String serverAddress);
}
