# tsl
<p>
    <a href="https://github.com/CodingPandaLLL/tsl/releases"><img src="https://img.shields.io/badge/版本-v1.0.4-brightgreen.svg" alt="版本" /></a>
    <a href="https://github.com/CodingPandaLLL/tsl.git"><img src="https://img.shields.io/badge/github-tsl-blue.svg" alt="github" /></a>
    <a href="https://github.com/CodingPandaLLL/tsl/releases"><img src="https://img.shields.io/badge/downloads-73.8k-brightgreen.svg" alt="downloads" /></a>
    <a href="https://github.com/CodingPandaLLL/tsl/commits"><img src="https://img.shields.io/badge/lastcommit-today-brightgreen.svg" alt="lastcommit" /></a>
    <a href="https://github.com/CodingPandaLLL"><img src="https://img.shields.io/badge/author-CodingPandaLLL-brightgreen.svg" alt="author" /></a>
    <a href="https://www.cnblogs.com/LiLiliang/"><img src="https://img.shields.io/badge/博客-CodingPanda-blueviolet.svg" alt="博客" /></a>
</p>

## 简介
tsl是基于springboot框架的一个基础框架。数据库端用到mysql，并集成了redis、rebbitMq等中间件。接口文档集成swagger作为自动化接口文档调用和使用。<br/>
## 框架介绍
### 代码结构
``` lua
tsl
├── annotation -- 自定义注解
├── bean -- 实体类包
├── config -- 系统配置类
├── controller -- 视图层类包
├── dao -- 数据访问层类包
├── demo -- 演示类包，主要用于预演功能
├── listener -- 监听类包，监听方法存放的位置，例如消息队列，日志等
├── service -- 服务接口类包
├── serviceImpl -- 服务实现类包
├── utils -- 工具类包，各种工具类存放位置
```
### 中间件依赖版本
| 中间件       | 版本             | 官网                                   |
| ---------- | --------------------- | -------------------------------------- |
| mysql        | 5.7.32-log             | https://www.mysql.com/                    |
| redis        | Redis 3.0.500          | https://redis.io/                    |
| rebitmq      | 3.7.4     | https://www.rabbitmq.com/                  |

## 版本说明
### V1.0.0版本
- 基础的增删除查改
### V1.0.1
- 添加redis作为mybatis的二级缓存
### V1.0.2
- 添加redis缓存，可讲数据缓存入redis
### V1.0.3
- 添加RebbitMq消息队列，可实现异步通信
### V1.0.4
- 添加redis作为定时器，实现倒计时提醒，订单超时提醒
- 集成swagger文档作为自动化接口文档
- 配置静态页面访问，添加默认首页
- 修改spring boot和一些第三方的依赖省级
- 添加写入文件工具类
- ### V1.0.5
- 更新首页文件处理
- 接入swagger自动化文档
- 更新spring boot版本和其他第三方版本
- 添加一些工具方法
- ### V1.0.6
- 添加数据字典功能
- 实现数据字典字段对应自定义属性增强
- 添加文件读取工具类
- 完善返回类ResultMap接口和方法
- 添加自定义接口超时自动熔断功能
- 完善启动服务不检查redis连接
- 升级fastjson版本，解决漏洞
- 升级原始swagger原始UI为Swagger-Bootstrap-UI

## 接口使用说明
swagger调用：http://127.0.0.1:8181/doc.html
