package com.peppa.wick.naming.nodes.theme.raft;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhengguangchen
 */


public class RaftNode {

      private String ip;
      private int port;
      public AtomicLong term = new AtomicLong(0L);



}
