package com.peppa.wick.core.event;

import com.peppa.wick.core.model.AppInfo;
import com.peppa.wick.core.model.Instance;
import com.peppa.wick.core.utils.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhengguangchen
 */


public class EventDispatcher {

    private ExecutorService eventExecute ;

    private BlockingQueue<AppInfo> changedServices = new LinkedBlockingQueue<AppInfo>();

    private ConcurrentHashMap<String, List<EventListener>> listenterWatchMap=new ConcurrentHashMap<>();

    public EventDispatcher() {
      eventExecute= Executors.newSingleThreadExecutor(new ThreadFactory() {
          @Override
          public Thread newThread(Runnable r) {
              Thread thread = new Thread(r,"com.peppa.wick.core.event.EventListener");
               thread.setDaemon(true);
              return thread;
          }
      });

      eventExecute.execute(new EventNotifier());
    }


    private class EventNotifier implements Runnable {
        @Override
        public void run() {
        while (true){
            AppInfo appInfo=null;
            try {
                appInfo=changedServices.poll(3,TimeUnit.MINUTES);
            } catch (InterruptedException e) {
            }
            if (appInfo==null){
              continue;
            }

            //找到这个服务所有的监听者,也就是所有调用这个服务的其他App
            List<EventListener> appEventListeners = listenterWatchMap.get(appInfo.getName());
            if (CollectionUtils.isEmpty(appEventListeners)){
                continue;
            }
            //通知每一个监听者
            List<Instance> instances = Collections.unmodifiableList(appInfo.getInstanceList());
            for (EventListener appEventListener : appEventListeners) {
             appEventListener.onEvent(new NamingEvent(appInfo.getName(),instances));
            }



        }

        }
    }
}
