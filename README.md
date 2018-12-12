# Redis

---

- NoSQL
	- Not Only SQL（非关系型数据库）
	- 为什么需要NoSQL
		1. High performance - 高并发读写
		2. Huge Storage - 海量数据的高效率存储和访问
		3. Hige Scalability && High Availability - 高扩展性和高可用性
	- 主流的NoSQL
		1. mongoDB
		2. Redis
		3. CouchDB
		4. memcacheDB
	- NoSQL数据库的四大分类
		1. 键值(Key-Valye)存储	
			- 优点：快速查询 
			- 缺点：存储的数据缺少结构化
			- 相关产品：Redis、Berkeley DB
			- 典型应用：内容缓存、主要用于处理大量数据的高访问负载
		2. 列存储	
			- 优点：快速查询，扩张性强 
			- 缺点：功能相对局限
			- 相关产品：HBase、Riak
			- 典型应用：分布式文件系统
		3. 文档数据库	
			- 优点：数据结构要求不是特别严格	
			- 缺点：缺少统一查询的语法，查询性能不高
			- 相关产品：CouchDB、MongoDB
			- 典型应用：Web应用（与Key-Value类似、Value是结构化的）
		4. 图形数据库	
			- 优点：利用图结构相关的算法	
			- 缺点：需要对整个图做计算，不容易做分布式的集群方案
			- 相关产品：Neo4J
			- 典型应用：社交网络、推荐系统等
	- NoSQL特点
		- 易扩展（数据之前去掉关系）
		- 灵活的数据模型
		- 大数据量、高性能
		- 高可用

---

- 什么是Redis
    - C语言开发的一个开源的高性能的键值对的数据库，它通过提供多种键值数据类型来使用不同场景下的存储需求
    - 支持类型
        1. 字符串类型
        2. 列表类型
        3. 有序集合类型
        4. 散列类型
        5. 集合类型
    - 应用场景
        1. **缓存**
        2. 任务队列（秒杀、抢购）
        3. 网站访问统计
        4. 数据过期处理
        5. 分布式集群架构中的session分离
    - 常用命令
        - ping
        - set key value
        - get key
        - del key
        - keys *
- Jedis
    - Java的Redis Clients
    
 - Redis的数据结构
    - 五种数据类型
        1. **字符串（String）**
        2. 字符串列表（list）
        3. 有序字符串集合（sorted set）
        4. **哈希（hash）**
        5. 字符串集合（set）
    - Key定义的注意点
        1. 不要过长（最好不要超过1024字节） 占内存，降效率
        2. 不要太短（降低可读性）
        3. 统一的命名规范
    - 存储String
        - 二进制安全的，存入和获取的数据相同
        - Value最多可以容纳的数据是512M
        - 存储String常用命令
            1. 赋值   set
            2. 取值   get
            3. 删除   del
            4. 扩展命令 incrby->将指定key对应的值增加指定数值 decrby append追加字符串
            5. 数值增减 incr(如果不存在，创建该key并将值设置为0，然后++，如果值无法++则抛出异常) decr