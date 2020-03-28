### bloom filter 代码原理以及实现
python
```python
from bitarray import bitarray
import mmh3
class BloomFilter:
    def __init__(self,size,hash_num):
        self.size = size
        self.hash_num = hash_num
        self.bit_array = bitarray(size)
        self.bit_array.setall(0)

    def add(self,s):
        for seed in range(self.hash_num):
            result = mmh3.hash(s,seed)%self.size
            self.bit_array[result] = 1


    def lookup(self,s):
        for seed in range(self.hash_num):
            result = mm3.hash(s,seed) % self.size
            if self.bit_array[result] == 0:
                return "Nope"
        return "Probably"

bf = BloomFilter(50000,7)
bf.add("dantezhao")
print(bf.lookup("dantezhao"))
print (bf.lookup("yyj")) 

```

