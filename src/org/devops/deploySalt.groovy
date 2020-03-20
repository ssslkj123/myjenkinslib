/*
该功能主要用于配置一个发布主机的功能。
本次的主机发布使用的是salt-master进行管理salt-minion的方式来实现发布的。
需要在执行发布的jenkins机器上安装salt-master的客户端，并提前配置好salt-minion的key认证。
*/
//for saltstack

def SaltDeploy(saltHosts,saltMod,saltParameters){
//定义一个saltstack的的方法函数。

  
  if ( saltPrameters.isEmpty() )  
  //使用判断方法isEmpty() 来进行判断saltParameters是否为空值.
  {
    println("saltPrameters is empty");
    sh "salt -L \"${saltHosts}\"   \"${saltMod}\"  ";
  }
  //else
  //{
  //sh "salt -L \"${saltHosts}\"   \"${saltMod}\"   \"${saltParameters}\"  ";
  //注意$ 与"特殊符号的转义。
  //}
}
