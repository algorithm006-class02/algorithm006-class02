=begin
题目描述：运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
=end

#解法：
class LRUCache
    attr_accessor :dic, :remain

    def initialize(capacity)
        self.dic = {}
        self.remain = capacity
    end

    def get(key)
        if !self.dic.has_key?(key)
            return -1
        end
        value = self.dic.delete(key)
        #对于散列表而言，新插入的键值对是在散列表中靠右的位置
        self.dic[key] = value
        return value
    end

    def put(key, value)
        if self.dic.has_key?(key)
            self.dic.delete(key)
        else
            if self.remain > 0
                self.remain -= 1
            else #如果缓存已满，则删除第一个键值对
                self.dic.shift
            end
        end
        self.dic[key] = value
    end
end