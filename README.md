# tsl
tsl是基于springboot框架的一个基础框架。数据库端用到mysql<br/>
## 版本说明
V1.0.0版本包含基础的增删除查改。<br/>
V1.0.1版本在V1.0.0的基础上添加redis作为mybatis的二级缓存。<br/>
V1.0.2版本在V1.0.1的基础上添加redis缓存，可讲数据缓存入redis。<br/>
V1.0.3版本在V1.0.2的基础上添加RebbitMq消息队列，可实现异步通信<br/>
V1.0.4版本在V1.0.3的基础上添加redis作为定时器，实现倒计时提醒，订单超时提醒<br/>
## 使用说明
swagger调用：http://127.0.0.1:8181/swagger-ui/index.html
