学习笔记
## week 07

### bitwise
+ 位或| 
+ 位与 &
+ 位取反 ~
+ 异或^ 0111^1011 -> 1100

#### 异或高级操作
x^0 = x
x^ 1s = ~s
x^(~x) = 1s
x^x = 0
c = a^b => a^c = b,b^c = a
a^b^c = a^(b^c) = (a^b)^c

### 某些移位的操作
1. 将 x 的最右边n位清零： x&(~0 << n )
2. 获取x 的第n位的值： (x>>n) &1
3. 获取x 的第n位的幂值： x&(1<<(n-1))
4. 将第n位置1：x|(1<< n )
5. 讲第n位置置0：x&(~(1<< n ))
6. x 最高位到第n位清零： x&(( 1<< n ) -1 )
7. x 第n位到第0 清零： x & ( ~ ((1<<(n+1)) -1 ))

#### 
x&（x-1） => 清零最后的1


## Bloom Filter
Bloom filter  用于判别一个元素是不是在一个集合里面，查询效率很高。

#### 应用场景
1. 网页爬虫的去重
2. 反垃圾邮件
3. 缓存击穿
 [原理](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877) [布隆过滤器(Bloom Filter)的原理和实现](https://www.cnblogs.com/cpselvis/p/6265825.html)


## LRU cache

less recently used?
示例代码
```python
class LRUCache(object):
    def __init__(self,capacity):
        self.dic = collections.OrderedDict()
        self.remain = capacity

    def get(self,key):
            if key not in self.dic:
                return -1
            v = self.dic.pop(key)
            self.dic[key] = v
            return v
    
    def put(self,key,value):
        if key in  self.dic:
            self.dic.pop(key)
        else:
            if self.remain > 0:
                self.remain -=-1
            else:
                self.dic.popitem(last = False)
        self.dic[key] = value
```