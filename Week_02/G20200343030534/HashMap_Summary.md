HashMap的实现：
HashMap也是使用一个数组来存储数据Node<K,V>[] table; Node是一个单向链表，具体实现如下。

每次往HashMap里添加数据时， 
1.首先会计算key的hash值，如果hash值不存在， 生成一个新Node对象（next为空），放到数组里。
在数组里的存放位置（index）由key的hash值决定。
2.如果hash值存在，从数据里取出当前值(currentVal)，从当前Node值里取出key，判断key值是否相同，
不相同的话，生成一个新Node对象（next为空），把这个新对象设置给currentVal.next.(这样是为了处理hash值相同的情况， 这是一个单向链表)
如果key值相同，就用新的value覆盖旧的value.

从HashMap里取数据时，也是先计算hash值，从数组里找到对应的Node,再比较Node里的Key,如果key不同，就取出Node里的next（Node）,再进行比较。


   static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

可以使用如下代码进行测试：
   public static void main(String[] args) {

        HashMap<String, String> set = new HashMap<>();
        set.put("轷龚", "first");
        set.put("轸齻", "second");//"轸齻"has same hashcode as "轷龚"
        set.put("轸齻", "nihao");
        set.put("1", "haha");
       System.out.println(set.size());
        System.out.println(set.get("轷龚"));
        System.out.println(set.get("轸齻"));
        System.out.println(set.get("1"));
        Set<Entry<String, String>> set2 = set.entrySet();
    }





