#!/usr/bin/env bash
###################################
#环境变量及程序执行参数
#需要根据实际环境以及Java程序名称来修改这些参数
###################################
#JDK所在路径
JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home"
#项目绝对路径
PROJECT_HOME="${project.root}"
#模块名称(需要更改)
MODULE_NAME="service_common"

#执行程序启动所使用的系统用户，考虑到安全，推荐不使用root帐号
RUNNING_USER=chen.nie
#maven打包过后的名称(需要更改)
APP_NAME="service-common-1.0-SNAPSHOT"

#Java程序所在的目录
APP_HOME="$PROJECT_HOME""$MODULE_NAME""/target/"

#需要启动的Java主程序（main方法类）需要更改
APP_MAINCLASS="com.mwee.bpm.oa.service.common.run.CommonServiceProvider"

SHELL_LOG="${shell.log.root}/shell_"$MODULE_NAME"_out.log"

SHELL_APP_LOG="${shell.log.root}/shell_"$MODULE_NAME"_app.log"
#java虚拟机启动参数
JAVA_OPTS="${java.opts}"
#配置文件路径
CONFIG_PATH=$APP_HOME$APP_NAME/config