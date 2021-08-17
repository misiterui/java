# Java 语言概述

## Java 技术体系平台

#### Java SE(Java Standard Edition)标准版

支持面向桌面级应用（如Windows下的应用程序）的Java平台，提供了完整的Java核 心API，此版本以前称为J2SE。

#### Java EE(Java Enterprise Edition)企业版

是为开发企业环境下的应用程序提供的一套解决方案。该技术体系中包含的技术如 :Servlet 、 Jsp等，主要针对于Web应用程序开发。版本以前称为J2EE。

#### Java ME(Java Micro Edition)小型版

支持Java程序运行在移动终端（手机、 PDA）上的平台，对Java API有所精简，并加 入了针对移动终端的支持，此版本以前称为J2ME。

#### Java Card

支持一些Java小程序（ Applets）运行在小内存设备（如智能卡）上的平台。

## Java语言运行机制及运行过程  

![image-20210317020448568](img\Java语言概述1.png)



## JDK, JRE, JVM 区别

#### JDK(Java Development Kit Java开发工具包)

JDK是提供给Java开发人员使用的，其中包含了java的开发工具，也包括了 JRE。所以安装了JDK，就不用在单独安装JRE了。 

其中的开发工具：编译工具(javac.exe) 打包工具(jar.exe)等

#### JRE(Java Runtime Environment Java运行环境)

包括Java虚拟机(JVM Java Virtual Machine)和Java程序所需的核心类库等， 如果想要运行一个开发好的Java程序，计算机中只需要安装JRE即可。

简单而言，使用JDK的开发工具完成的java程序，交给JRE去运行。  

#### JVM(JVM Java Virtual Machine)

Java虚拟机

JDK = JRE + 开发工具集（例如Javac编译工具等）  

JRE = JVM + Java SE标准类库  

![image-20210317023041782](img\Java语言概述2.png)

