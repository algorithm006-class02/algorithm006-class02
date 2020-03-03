Note: 

# Java HashMap summary

- HashMap is not synchronized.

- Permits null values and null key.

- The HashMap class is roughly equivalent to Hashtable, 
except that it is unsynchronized and permits null.

- iteration: all buckets and its size(the number of key-value mappings) (!!!capacity not too high or load factor too low)

- default load factor: 0.75 (offers good trade off between time and space cost)

- When the number of entries in the hash table exceeds the product of the load factor and the current capacity, the hash table is rehashed 
 (that is, internal data structures are rebuilt) so that the hash table has approximately twice the number of buckets.

- too many mappings are to be stored in HashMap instance, create HasHMap with a large 
capacity, because automatic rehashing takes time. 

- And if there are too many keys with the same `hashCode()`, making these keys `Comparable` 
helps break ties.

- Synchronized HashMap:

`Map m = Collections.synchronizedMap(new HashMap(...))`

- `clone` return a shallow copy of this Map

- `treeifyBin` the number of linked nodes in a bin is larger than specified threshold, the treeify the bin