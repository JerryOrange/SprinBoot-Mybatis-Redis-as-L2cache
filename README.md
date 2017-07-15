# Spring-Boot-Mybatis-Redis-as-L2cache
使用Spring Boot快速搭建一个Web应用，并且采用Mybatis作为ORM框架。为了提升性能，将Redis作为Mybatis的二级缓存。

Spring Boot因其提供了各种开箱即用的插件，使得它成为了当今最为主流的Java Web开发框架之一。
通过 Spring Boot，创建新的 Spring 应用变得非常容易。

Mybatis是一个十分轻量好用的ORM框架。Redis是当今十分主流的分布式key-value型数据库，在web开发中，常用被用来缓存数据库的查询结果。

Demo中使用Spring Boot快速搭建一个Web应用，并且采用Mybatis作为我们的ORM框架。为了提升性能，将Redis作为Mybatis的二级缓存。并编写了单元测试，用H2内存数据库来生成我们的测试数据。通过该项目，我们希望读者可以快速掌握现代化Java Web开发的技巧以及最佳实践。

数据库二级缓存在Redis中的存储方式：Redis会自动的将Sql+条件+Hash等当做key值，而将查询结果作为value，只有请求中的所有参数都符合，那么就会自动获取redis中的二级缓存。

使用 YAML 表示配置属性（application.yml）相对于属性文件来说，YAML 是一个更好的配置文件格式。YAML 在 Ruby on Rails 中得到了很好的应用。SpringApplication 类也提供了对 YAML 配置文件的支持，只需要添加对 SnakeYAML 的依赖即可。

局限性：Mybatis的二级缓存只能通过flush整个数据库来实现缓存失效。

参考：

http://www.baeldung.com/spring-data-redis-tutorial

http://chrisbaileydeveloper.com/projects/spring-boot-redis-heroku-demo/

http://docs.spring.io/spring-data/redis/docs/1.6.2.RELEASE/reference/html/

http://blog.didispace.com/springbootredis/

