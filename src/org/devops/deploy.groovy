/*
该功能主要用于配置一个发布主机的功能。
本次的主机发布使用的是salt-master进行管理salt-minion的方式来实现发布的。
需要在执行发布的jenkins机器上安装salt-master的客户端，并提前配置好salt-minion的key认证。
*/
//for saltstack

def SaltDeploy(hosts,func){
//定义一个saltstack的的方法函数。
  sh "salt \"\${hosts}\" \"\${func}\"  ";
//注意$ 与"特殊符号的转义。
}
