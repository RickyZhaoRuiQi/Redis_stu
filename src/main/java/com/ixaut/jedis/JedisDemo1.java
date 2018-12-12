package com.ixaut.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis的测试
 * Ricky
 */

public class JedisDemo1 {
   /**
    *
    * 单实例测试
    * */

   public static void main(String[] args) {
       JedisDemo1 j = new JedisDemo1();
       //j.demo1();
       j.demo2();
   }

   public void demo1(){
       //1.设置IP地址和端口
       Jedis jedis = new Jedis("127.0.01",6379);
       //2.保存数据
       jedis.set("name","imooc");
       //3.获取数据
       String value = jedis.get("name");
       System.out.println(value);
       //4.释放资源
       jedis.close();
   }

   /**
    * 连接池方式来凝结
    * */
   public void demo2(){
       //获得连接池配置对象
       JedisPoolConfig config = new JedisPoolConfig();
       //设置最大连接数
       config.setMaxTotal(30);
       //设置最大空闲连接数
       config.setMaxIdle(10);
       //获得连接池
       JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);
       //获得核心对象
       Jedis jedis = null;
       try{
           //通过连接池来获得连接
           jedis = jedisPool.getResource();
           //设置数据
           jedis.set("name","li4");
           String value = jedis.get("name");
           System.out.println(value);
       }catch(Exception e){
           e.printStackTrace();
       }finally {
           //释放资源
           if(jedis != null)
               jedis.close();
           if(jedisPool != null)
               jedisPool.close();
       }
   }
}
