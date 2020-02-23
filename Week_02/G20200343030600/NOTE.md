### 学习笔记
递归思维要点：
- 抵制人肉递归；
- 找最近重复性；
- 数学归纳法思维；

递归的特性和时空复杂度：
- 递归定义：函数自己调用自己
- 递归的实质：压系统栈。压到栈里的是当前的所有信息，包括当前跑到多少行，当前的参数和函数中的局部变量等等；返回后再进行弹栈，然后读取弹栈后栈顶空间的信息，也就是返回到调用的地方。
- 递归可能会导致内存溢出是因为栈太过深了才可能会导致内存溢出。
- 递归都可以转化为迭代(手动建个栈，每次循环把需要的数据压进去，循环完弹出来)。
- 递归的时间复杂度：递归总次数*每次递归的时间复杂度
- 递归的空间复杂度：递归的深度*每次递归空间的大小
- 递归本身并不存在效率低的问题，锅是程序本身的算法复杂度写残。(eg. 斐波拉契数列傻递归没有用缓存)

**Python代码模板**
```python
def recursion(level, param1, param2, ...): 
    # recursion terminator 
    if level > MAX_LEVEL: 
	   process_result 
	   return 

    # process logic in current level 
    process(level, data...) 

    # drill down 
    self.recursion(level + 1, p1, ...) 

    # reverse the current level status if needed
```

**Java代码模板**
```java
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 

  // process current logic 
  process(level, param); 

  // drill down 
  recur( level: level + 1, newParam); 

  // restore current status 
}
```
