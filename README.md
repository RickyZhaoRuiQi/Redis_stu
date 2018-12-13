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
    - 存储Hash
        - String Key和String Value的map容器
        - 每一个Hash可以存储4294967295个键值对
        - 常用命令
            1. 赋值   hset hmset(同时设置多个)
            2. 取值   hget hmget mhgetall(得到某个hash中的所有键值对)
            3. 删除   hdel：删除hash中的某个值 del：删除整个hash
            4. 自学命令 hexists hash key：判断是否存在 hlen hash：判断长度  hkeys hash：得到所有属性名称 hvals：得到所有值
            5. 增加数值 hincrby hdecrby
    - 存储List
        - ArrayList使用数组方式
        - LikedList使用双向链接方式
        - 双向链表中增加数据
        - 双向链表中删除数据
        - 常用命令
            1. 两端添加 lpush list [values]：左添加 rpush list [values]：右添加
            2. 查看列表 lrange list
            3. 两端弹出 lpop list：左弹出 rpop list：右弹出
            4. 获取列表元素个数 llen list
            5. 扩展命令 lpushx list value：向list头部插入value rpush list value：向list尾部插入value    lrem list count value：删除count个value lset list index value：设置下表为index索引位置的值为value    linsert list [before|after] pivot value：在pivot之前之后插入value   rpoplpush list1 list2：弹出list1尾部的值并插入到list2头部
    - 存储Set
        - 和List类型不同的是，Set集合中不允许出现重复的元素
        - Set可包含的最大元素数量4294967295
        - 常用命令
            1. 添加/删除元素  add set [values]：向set中添加 srem set [values]：从set中删除
            2. 获得集合中的元素 smembers set：查看set中的元素  sismember set value：判断是否存在
            3. 集合中的差集运算 sdiff set1 set2：求set1和set2的差集
            4. 集合中的交集运算 sinter set1 set2：求set1和set2的交集
            5. 集合中的并集运算 sunion set1 set2：求set1和set2并集
            6. 扩展命令 scard set：得到集合中元素数量 srandmember set：得到set中一个随机元素    sdiffstore(sinterstore sunion) newset set1 set2：将set1和set2差（交、并）集存入newset
        - 使用场景
            - 跟踪一些**唯一性数据**
            - 用于维护数据对象之间的关联关系
    - 存储Sorted-Set
        - 与Set区别是每个值都有一个权值进行排序
        - 集合中位置有序，访问中间元素也是高效的
        - 常用命令
            1. 添加元素 zadd sorted-set [score value]：向有序集中添加权值为score的value 
            2. 删除元素 zrem sorted-set [values]：删除 zremrangebyrank sorted-set start end：按照范围删除 zremrangebyscore sorted-set score1 score2：按照分数范围删除
            3. 获得元素 zsore sorted-set value：获得value的分数   zcard sorted-set:获得集合数量
            4. 范围查询 zrange sorted-set start end：查询  zreverange sorted-set start end：升序查询    
            5. 扩展命令 limit start end： 限制显示   zincreby sorted-set number value：将value权值加number
        - 使用场景
            - 大型游戏在线积分排行榜
            - 构建索引数据
    - Keys通用操作
        - keys * 查看所有key    keys m* 查看以m开头的key
        - del [keys] 删除keys
        - exists key 查看key是否存在
        - rename key newkey 重命令
        - expire key time 设置过期时间 单位s
        - ttl key 查看剩余超时时间
        - type key 获得key类型
        
 ---
 
 - Redis特性
    - 多数据库
        - 最多16个数据库 select index切换数据库
        - move key index 移动key到index数据库
    - 支持事务
        - multi：开启事务
        - exec：提交
        - discard：回滚
    - Redis持久化
        - RDB方式：默认支持，不同配置。在指定时间间隔内，将数据写入到磁盘
        - AOF方式：以日志的形式存储每个操作，启动后读取日志构建数据
        - 无持久化：
        - RDB & AOF

---
    