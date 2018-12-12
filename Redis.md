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