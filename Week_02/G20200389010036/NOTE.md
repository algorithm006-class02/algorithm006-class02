学习笔记

```
for 空数组不会执行
>>> for i in []:
...     print("run")
...     print(i)
...
>>>

list 添加元素使用append
>>> res = []
>>> res[0]=1
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
IndexError: list assignment index out of range
>>> res.append([])
>>> res
[[]]
>>> res[0].append(1)
>>> res
[[1]]
>>> res[0].append(2)
>>> res
[[1, 2]]
>>> res[1].append(2)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
IndexError: list index out of range
>>> res.append([])
>>> res
[[1, 2], []]
>>> res[1].append(2)
>>> res
[[1, 2], [2]]

s.pop([i])
he optional argument i defaults to -1, so that by default the last item is removed and returned.

递归函数最后一层不执行返回None
>>> def test(a):
...     if a < 0:
...             return a
...
>>> print(test(1))
None

```