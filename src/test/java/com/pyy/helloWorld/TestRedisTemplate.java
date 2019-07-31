package com.pyy.helloWorld;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString(){
//        redisTemplate.opsForValue().set("key_three","hello3");
        System.out.println("value = "+redisTemplate.opsForValue().get("key_four"));
//        Assert.assertEquals("hello",redisTemplate.opsForValue().get("ccc"));
    }


    //List应用场景就是消息队列
    @Test
    public void testList(){

        /**
         * Redis list 的实现为一个双向链表，
         * 即可以支持反向查找和遍历，更方便操作，
         * 不过带来了部分额外的内存开销，
         * Redis 内部的很多实现，包括发送缓冲队列等也都是用的这个数据结构
         */
        ListOperations<String, String> list = redisTemplate.opsForList();
        list.leftPush("list","a");
        list.leftPush("list","b");
        list.leftPush("list","c");
        String value = list.leftPop("list");
        System.out.println("list value :"+value);

        List<String> range = list.range("list", 0, 2);
        for (String str : range) {
            System.out.println("list str :"+str);
        }
    }


    //redis Set 具有List同样的功能，而且还能有查重的效果
    @Test
    public void testSet(){
        SetOperations setOperations = redisTemplate.opsForSet();
//        setOperations.add("set","aa");
//        setOperations.add("set","bb");
//        setOperations.add("set","cc");
//        setOperations.add("set","aa");
//
//        Set<String> values = setOperations.members("set");
//        for (String v:values) {
//            System.out.println("set value :"+v);
//        }

        //set value :cc
        //set value :bb
        //set value :aa


//        String key1="setMore1";
//        String key2="setMore2";
//        setOperations.add(key1,"it");
//        setOperations.add(key1,"you");
//        setOperations.add(key1,"you");
//        setOperations.add(key1,"know");
//        setOperations.add(key2,"xx");
//        setOperations.add(key2,"know");
//
//        //difference() 函数会把 key1 中不同于 key2 的数据对比出来
//        //适合我们在金融场景中对账的时候使用
//        Set<String> diffs=setOperations.difference(key1,key2);
//        for (String v:diffs){
//            System.out.println("diffs set value :"+v);
//        }


        //unions 会取两个集合的合集
        String key3="setMore3";
        String key4="setMore4";
        setOperations.add(key3,"it");
        setOperations.add(key3,"you");
        setOperations.add(key3,"xx");
        setOperations.add(key4,"aa");
        setOperations.add(key4,"bb");
        setOperations.add(key4,"know");
        Set<String> unions=setOperations.union(key3,key4);
        for (String v:unions){
            System.out.println("unions value :"+v);
        }
    }


    /**
     * Redis sorted set 的使用场景与 set 类似，
     * 区别是 set 不是自动有序的，而 sorted set 可以通过用户额外提供一个优先级（score）的参数来为成员排序，并且是插入有序，即自动排序。
     *
     * 在使用 Zset 的时候需要额外的输入一个参数 score，
     * Zset 会自动根据 Score 的值对集合进行排序，
     * 我们可以利用这个特性来做具有权重的队列，
     * 比如普通消息的 score 为1，重要消息的 score 为2，然后工作线程可以选择按 score 的倒序来获取工作任务
     */
    @Test
    public void testZset(){
        String key = "zset";
        redisTemplate.delete(key);

        ZSetOperations zSet = redisTemplate.opsForZSet();
        zSet.add(key,"i",9);
        zSet.add(key,"love",8);
        zSet.add(key,"u",10);

        Set<String> values = zSet.range(key, 0, 2);
        for (String v:values){
            System.out.println(" value :"+v);
        }

        //Redis sorted set 的内部使用 HashMap 和跳跃表（SkipList）来保证数据的存储和有序，
        // HashMap 里放的是成员到 score 的映射，而跳跃表里存放的是所有的成员，
        // 排序依据是 HashMap 里存的 score，使用跳跃表的结构可以获得比较高的查找效率，并且在实现上比较简单。
        Set<String> rangeByScore = zSet.rangeByScore(key, 8, 10);

        for (String v:rangeByScore){
            System.out.println(" value :"+v);
        }
    }



}
