### Python Set && Dict(Map)

[Source Code set](https://github.com/python/cpython/blob/2.7/Lib/sets.py)
[Source Code Dict](https://github.com/python/cpython/blob/2.7/Lib/UserDict.py)


[Set Objects](https://docs.python.org/2/library/sets.html)

具体支持方法为：
>ImmutableSet && Set
+ len（s）
+ x in s 
+ x not in s 
+ s.issubset(t)    (s包含t?)
+ s.issuperset(t) (s>=t?)
+ s.union(t) s|t
+ s.intersection(t) s&t
+ s.difference(t)     s-t
+ s.symmetric_didderence(t) s^t
+ s.copy() 

> ImmutableSet 特有 hash（s)


> Set 特有

+ s.update(t) s |= t
+ s.intersection_update(t) s &= t
+ s.difference_update(t) s -= t
+ s.symmetric_difference_update(t)  s ^= t
+ s.remove(x)

    remove x from set s; raises KeyError if not present

+ s.discard(x)

    removes x from set s if present

+ s.pop()

    remove and return an arbitrary element from s; raises KeyError if empty

+ s.clear()

    remove all elements from set s
```python
>>> from sets import Set
>>> engineers = Set(['John', 'Jane', 'Jack', 'Janice'])
>>> programmers = Set(['Jack', 'Sam', 'Susan', 'Janice'])
>>> managers = Set(['Jane', 'Jack', 'Susan', 'Zack'])
>>> employees = engineers | programmers | managers           # union
>>> engineering_management = engineers & managers            # intersection
>>> fulltime_management = managers - engineers - programmers # difference
>>> engineers.add('Marvin')                                  # add element
>>> print engineers 
Set(['Jane', 'Marvin', 'Janice', 'John', 'Jack'])
>>> employees.issuperset(engineers)     # superset test
False
>>> employees.update(engineers)         # update from another set
>>> employees.issuperset(engineers)
True
>>> for group in [engineers, programmers, managers, employees]: 
...     group.discard('Susan')          # unconditionally remove element
...     print group
...
Set(['Jane', 'Marvin', 'Janice', 'John', 'Jack'])
Set(['Janice', 'Jack', 'Sam'])
Set(['Jane', 'Zack', 'Jack'])
Set(['Jack', 'Sam', 'Jane', 'Marvin', 'Janice', 'John', 'Zack'])

```

### Dictionary
[dict](https://docs.python.org/3/library/stdtypes.html#typesmapping)

pairs = zip(d.values(), d.keys())
+ d[key] = value
 Set d[key] to value.

+ del d[key]
Remove d[key] from d. Raises a KeyError if key is not in the map.

+ key in d
Return True if d has a key key, else False.

+ key not in d
Equivalent to not key in d.

+ iter(d)
Return an iterator over the keys of the dictionary. This is a shortcut for iter(d.keys()).

+ clear()
Remove all items from the dictionary.

+ copy()
Return a shallow copy of the dictionary.

classmethod fromkeys(iterable[, value])
Create a new dictionary with keys from iterable and values set to value.

+ fromkeys() is a class method that returns a new dictionary. value defaults to None. All of the values refer to just a single instance, so it generally doesn’t make sense for value to be a mutable object such as an empty list. To get distinct values, use a dict comprehension instead.

+ get(key[, default])
Return the value for key if key is in the dictionary, else default. If default is not given, it defaults to None, so that this method never raises a KeyError.

+ items()
Return a new view of the dictionary’s items ((key, value) pairs). See the documentation of view objects.

+ keys()
Return a new view of the dictionary’s keys. See the documentation of view objects.

pop(key[, default])
If key is in the dictionary, remove it and return its value, else return default. If default is not given and key is not in the dictionary, a KeyError is raised.

+ popitem()
Remove and return a (key, value) pair from the dictionary. Pairs are returned in LIFO order.

 popitem() is useful to destructively iterate over a dictionary, as often used in set algorithms. If the dictionary is empty, calling popitem() raises a KeyError.

Changed in version 3.7: LIFO order is now guaranteed. In prior versions, popitem() would return an arbitrary key/value pair.

+ reversed(d)
Return a reverse iterator over the keys of the dictionary. This is a shortcut for reversed(d.keys()).

New in version 3.8.

+ setdefault(key[, default])
If key is in the dictionary, return its value. If not, insert key with a value of default and return default. default defaults to None.

+ update([other])
Update the dictionary with the key/value pairs from other, overwriting existing keys. Return None.

 + update() 
 accepts either another dictionary object or an iterable of key/value pairs (as tuples or other iterables of length two). If keyword arguments are specified, the dictionary is then updated with those key/value pairs: d.update(red=1, blue=2).

+ values()
Return a new view of the dictionary’s values. See the documentation of view objects.