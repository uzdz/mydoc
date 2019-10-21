# MyDoc 接口文档系统

#### 联系方式:
> ****Name：**** uzdz </br>
> ****Email：**** devmen@163.com <br/>
> ****QQ：**** 714973366

# 数据库表结构导入

> 请将resources目录的myDoc.sql文件导入至本地或远程MySQL数据库即可。

# 系统功能UI图

![image](https://raw.githubusercontent.com/uzdz/mydoc/master/src/main/webapp/WEB-INF/images/1.png)

![image](https://raw.githubusercontent.com/uzdz/mydoc/master/src/main/webapp/WEB-INF/images/2.png)

![image](https://raw.githubusercontent.com/uzdz/mydoc/master/src/main/webapp/WEB-INF/images/3.png)

![image](https://raw.githubusercontent.com/uzdz/mydoc/master/src/main/webapp/WEB-INF/images/4.png)

![image](https://raw.githubusercontent.com/uzdz/mydoc/master/src/main/webapp/WEB-INF/images/5.png)

![image](https://raw.githubusercontent.com/uzdz/mydoc/master/src/main/webapp/WEB-INF/images/6.png)

![image](https://raw.githubusercontent.com/uzdz/mydoc/master/src/main/webapp/WEB-INF/images/7.png)

# Docker快速使用

## Docker Hub快速使用

#### 下载Mysql镜像并创建容器

> 安装好mysql后，将项目resources目录的myDoc.sql文件导入到该mysql数据库中（可通过可视化工具）。

```shell script
docker pull mysql:5.6
```

```shell script
docker run -p 3306:3306 --name mysqlDate -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.6
```

#### 下载Mydoc镜像并创建容器

> 注意：mydoc镜像中不包含mysql数据库，所以需要依赖外部数据库。通过--link命令传入一个alias的mysql别名。其中别名名称必须为mysql_server。

```shell script
docker pull uzdz/mydoc
```

```shell script
docker run --name mydoc --link mysqlDate:mysql_server -p 8080:8080 uzdz/mydoc
```

#### 访问网页

> http://localhost:8080/mydoc

## 源码构建镜像
> 请事先下载jdk包与tomcat包，并放置到根目录下（必须，可以参考或修改Dockerfile），推荐包版本如下：

* apache-tomcat-8.5.46.tar.gz
* jdk1.8.0.tar.gz

#### 编译
> 在根目录下运行：

```shell script
mvn clean
```

```shell script
mvn install -Dmaven.test.skip=true
```

#### 构建镜像

```shell script
docker build --no-cache -t uzdz/mydoc:v1 .
```

#### 运行镜像创建容器

```shell script
docker run --name mydoc --link mysqlDate:mysql_server -p 8080:8080 uzdz/mydoc
```