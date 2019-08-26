# john-wick
john-wick是一款服务发现框架(--取自电影<<疾速追杀>> "Wherever you are, I will find you, I will kill you")<br>
## what does it do
#### 模式切换
相当于与eureka和nacos等注册中心相比，wick对于节点的同步有多种主题模式:<br>
* sql模式<br>
相比于nacos的raft算法实现节点同步，wick提供了基于mysql同步节点状态的方式，相比较而言实现更加的简单高效，对使用者来说不在是黑盒.<br>
* raft模式<br>
基于raft算法实现节点信息的同步检测，对比与eureka的长轮训实现最终一致性而言，节点的信息同步更快，一致性更高<br>
#### 故障转移
当服务使用sql模式的时候，如果mysql发生了故障，wick会自动检测mysql，并尝试自动切换到基于内存和文件的raft模式，并实时检测mysql的最新状态，当mysql恢复的时候，自动切换回sql模式，并同步数据<br>
#### 可视化管理
wick提供了丰富的可视化管理后台，实现节点的实时状态查看，以及手动的节点拉入和拉出，手动刷新等功能<br>


## how does it do
App是一个服务的概述，一个app由多个instance实例组成,（后续会支持 cluster 集群）<br>
naming是服务端，client是客户端,概述图如下<br>
![概述图](https://haiyi-file.zhimeizhushou.com/editfile/6ea827df-a755-424e-b5d2-f543b1c75e13.png) 


