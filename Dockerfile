FROM centos:7

MAINTAINER uzdz devmen@163.com

ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

# 安装JDK
RUN mkdir /var/tmp/jdk
COPY jdk1.8.0.tar.gz /var/tmp/jdk/
RUN tar xzf /var/tmp/jdk/jdk1.8.0.tar.gz -C /var/tmp/jdk/ && rm -rf /var/tmp/jdk/jdk1.8.0.tar.gz

# 安装tomcat
RUN mkdir /var/tmp/tomcat
COPY apache-tomcat-8.5.46.tar.gz /var/tmp/tomcat/
RUN tar xzf /var/tmp/tomcat/apache-tomcat-8.5.46.tar.gz -C /var/tmp/tomcat/ && rm -rf /var/tmp/tomcat/apache-tomcat-8.5.46.tar.gz

# 打包项目并拷贝到tomcat webapps目录
COPY ./target/mydoc.war /var/tmp/tomcat/apache-tomcat-8.5.46/webapps/

# 设置环境变量
ENV JAVA_HOME /var/tmp/jdk/jdk1.8.0
ENV CATALINA_HOME /var/tmp/tomcat/apache-tomcat-8.5.46
ENV PATH $PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin

# 开启内部服务端口
EXPOSE 8080

EXPOSE 3306

CMD /var/tmp/tomcat/apache-tomcat-8.5.46/bin/startup.sh && tail -F /var/tmp/tomcat/apache-tomcat-8.5.46/logs/catalina.out