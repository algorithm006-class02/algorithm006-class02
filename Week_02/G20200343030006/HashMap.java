package com.leetcode.base.week02;


    /*
        HashMap总结：
       HashMap的底层实现原理：（jdk 7数组(Entry[] table)+链表）
            向HashMap中添加key1-value1。首先根据key1所在类的hashCode()，计算key1的哈希值1，使用某种算法得到哈希值2
            使用哈希值2通过某种算法得到key1-value1在底层table[]中的索引位置:i
      1)如果table[i] == null:则此key1-value1添加成功  ---情况1
      2)如果table[i]位置上存在其他entry2(key2-value2)等,则比较key1和key2（,key3,...的哈希值2：
            如果和已的entry的key的哈希值2彼此都不同：则key1-value1添加成功---情况2
            如果和已的entry中的某一个entry的key的哈希值2相同，继续比较二者的equals():
            									返回true:使用value1替换相同哈希值的key的value
             									返回false:继续与索引i位置上的其他entry比较，如果都不相同。则添加成功---情况3
            情况1：将key1-value1添加到数组中
            情况2，情况3：将key1-value1与以后的key-value以链表的方式进行存储。（七上八下）

            扩容问题：
            默认情况下：（new HashMap()创建的对象此时底层数组的长度是16.
            当达到临界值(= 数组的长度 *加载因子(默认的加载因子：0.75))时，就考虑扩容。扩容为原来的2倍

      HashMap在jdk8中相较于jdk7在底层实现方面的不同：
      1.new HashMap():此时底层并没创建长度为16的数组
      2.当首次调用put()方法添加元素时，才在底层创建长度为16的数组
      3.新添加的元素与已的元素如果以链表方式存储的话，jdk8中是旧的元素指向新添加的元素
      4.当某个索引i位置上的链表的长度 > 8且数组的长度大于64时，此索引i位置上的元素不再以链表方式存储，而是改为红黑树。
      */
public class HashMap {


}
