package org.devops
//定义一个封装，共享库整合封装工具。

//定义一个方法Build() 指定构造工具与构造参数.
def  Build(buildType,buildShell){  
//定义一个类型是Build当中包含两个参数buildType和buildShell,buildType为构造工具，buildShell为工具后的具体参数.
  
  def buildTools = ["mvn":"m2","ant":"ANT","gradle":"GRADLE","npm":"NPM"];
  //定义一个叫做buildTools的字典.
  //key为具体的打包命令，value为jenkins当中全局工具某个具体工具的名称,这里如：m2是maven的全局配置工具自定义名称.
                
  buildHome = tool buildTools[buildType];
  //定义一个buildHome 通过字典的形式将方法的buildType字段传入到字典buildTools当中，并将值赋值给buildHome变量.
  
  if (${buildType} == npm ){
	  sh "export PATH=\$PATH:${buildHome}/bin && ${buildHome}/bin/${buildType} ${buildShell}";
	  //由于npm构建工具环境变量的问题，所以在此作一个判断.
  }
  else {
	  sh "${buildHome}/bin/${buildType} ${buildShell}";
  //调用操作系统命令行shell 执行构建，本质上是传入了打包命令的目录 + 构造命令函数.
  }
}
