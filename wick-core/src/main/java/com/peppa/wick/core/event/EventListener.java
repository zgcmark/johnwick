package com.peppa.wick.core.event;

/**
 * @author zhengguangchen
 */


public interface EventListener {

    /**监听器的回调时间
     * @param event
     */
    void onEvent(Event event);



}
