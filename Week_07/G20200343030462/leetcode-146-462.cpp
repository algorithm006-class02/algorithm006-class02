class LRUCache {
    int m_capacitiy {0};
    list<pair<int,int>> cache;      //list中以pair来存储数据
    unordered_map<int,list<pair<int,int>>::iterator> poscache;  //key是要查找的key，value是pair在list中的位置
public:
    LRUCache(int capacity) {
        m_capacitiy = capacity;
    }
    
    int get(int key) {
        auto pos = poscache.find(key);
        if(poscache.end() == pos)
            return -1;
        //找到了就从链表中删除此元素，然后将它插入到链表头部，并更新其在poscache中的位置
        auto value = *poscache[key];
        cache.erase(poscache[key]);
        cache.push_front(value);
        poscache[key] = cache.begin();
        return value.second;
    }
    
    void put(int key, int value) {
        //先检查该元素是不是已经在缓存中了
        auto pos = poscache.find(key);
        if(pos == poscache.end())
        {
            //如果不在缓存中，那么插入时要判断缓存是不是已经满了
            if(cache.size() == m_capacitiy)
            {
                //已满，删除最后一个元素
                auto lastValue = cache.back();
                poscache.erase(lastValue.first);
                cache.pop_back();
            }
            //不管是满还是没有满，都把新元素插入到首元素位置
            cache.push_front(pair<int,int>(key,value));
            poscache[key] = cache.begin();
        }
        else
        {
            //如果已经在了，那就把它移动到链表的最前端
            cache.erase(poscache[key]);
            cache.push_front(pair<int,int>(key,value));
            poscache[key] = cache.begin();
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
