Home-Edu
=
### 项目简介
    本项目是属于2012级HDU的一个毕设项目，题材是以学生家教为背景，通过对学生以及老师两种角色的分配，使双方都能有针对性的浏览与预定相应的对象。因为定性为毕设项目，所以其中涉及的业务逻辑以及相关技术并没有那么的严谨，仅供参考学习。

---
### 项目涉及技术
* 前端技术：css+jquery，无框架
* 后台技术：springmvc+spring+mybatis+Java+jsp
* 数据库：Mysql数据库
* 消息推送：[Goeasy](http://goeasy.io/)
* 邮件通知：javamail+qq通道

### 项目部署
1. 将项目`fork`到本地
2. 导入至`Eclipse IDE`或者`IntelliJ`IDE工具
3. 导出格式为`war`类型的war包或者直接在IDE工具中跑
4. 将war包部署在`Jetty/Tomcat`的`webapps`目录下
5. 启动web容器，浏览器输入`http://[ip]:[port]/Home-Edu/`即可访问

### Note
1. contextPath定为`Home-Edu`，如需要修改，请相应修改jsp文件中的css片段。以免图片加载失败
2. 在项目部署前请务必执行相应的home_edu.sql，并且参照jdbc.properties做相应的帐号/密码修改
3. 本项目主要采用jsp作为前台展示页面，效果粗糙，可适当自我优化
