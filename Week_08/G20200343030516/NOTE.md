学习笔记

### week--08 

### Advanced DP

### 递归到动态规划的一般转化方法：
递归函数具有N个参数，就定义一个n维数组，数组的下标是递归函数参数的取值范围，数值元素的值是递归函数的返回值，这样就可以从边界值开始，逐步填充数组，相当于计算递归函数值的逆过程。

### 动态规划问题的一般思路
1. 将原问题分解为子问题
   + 讲原问题分解为若干个子问题，子问题和原问题形式的解类似或者相同，但是规模变小。 子问题都解决的话，原问题就可以得到解。
   + 子问题的解一旦求出就会保存，所以每个子问题只需求解一次。
2. 确定状态
   +  使用动态规划结题的时候，我们往往将子问题和相关问题的各个变量一组取值，称之为一个状态。
   + 一个 "状态",对应一个或者多个子问题，所谓某个状态下的值，就是这个状态下所对应的子问题的解。
   + 整个问题的时间复杂度是状态数目乘以计算每所需时间。

3.  寻找边界条件

    以"数字三角形" 为例，初始状态是底边数字， 值为底边数字值

4.  确定状态转移方程
    定义出什么是“状态”，以及在该 “状态”下的值后，找出不同的状态之间如何迁移即如何从一个或多“值”已知的求出另一个“状态” 的值(“人为我”递推型 )。状态的迁移可以用递推公式表示此也被称作“状转方程”。


###  能够使用动态规划结题问题的特点  

1） **问题具有最优子结构的性质**。
如果问题最优解包含子结构的解也是最优的，我们称该问题具有最优子结构。
2） **无后效性**。当前的若干个状态值一旦确定，则此后的演变就只和这个状态值有关，和之前采取哪种手段，如何到到这个状态的，没有任何关系。

### 动态规划的两种形式
 1. 递归
 直观，容易编写
 递归层数太深，容易爆栈，函数调用也会带来额外开销

 2. 递推
 效率高，有可能使用滚动数组节省空间
 （人人为我型递推，我为人人型）

### 高级动态规划
高级动态规划需要定义更多状态变量，递推方程需要考虑维度更高。

### 递归模板
```python
def recursion(level,param1):
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

### 分治代码模板
```python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 

  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states

```


### String 

#### js String 对象
https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/String

### regex
### string 方法
跟HTML无关的方法

String.prototype.charAt()
    返回特定位置的字符。
    
String.prototype.charCodeAt()
    返回表示给定索引的字符的Unicode的值。

String.prototype.codePointAt()
    返回使用UTF-16编码的给定位置的值的非负整数。

String.prototype.concat()
    连接两个字符串文本，并返回一个新的字符串。

String.prototype.includes()
    判断一个字符串里是否包含其他字符串。

String.prototype.endsWith()
    判断一个字符串的是否以给定字符串结尾，结果返回布尔值。

String.prototype.indexOf()
    从字符串对象中返回首个被发现的给定值的索引值，如果没有找到则返回-1。

String.prototype.lastIndexOf()
    从字符串对象中返回最后一个被发现的给定值的索引值，如果没有找到则返回-1。

String.prototype.localeCompare()
    返回一个数字表示是否引用字符串在排序中位于比较字符串的前面，后面，或者二者相同。

String.prototype.match()
    使用正则表达式与字符串相比较。

String.prototype.normalize()
    返回调用字符串值的Unicode标准化形式。

String.prototype.padEnd()
    在当前字符串尾部填充指定的字符串， 直到达到指定的长度。 返回一个新的字符串。

String.prototype.padStart()

    在当前字符串头部填充指定的字符串， 直到达到指定的长度。 返回一个新的字符串。

String.prototype.quote()
    设置嵌入引用的引号类型。
String.prototype.repeat()
    返回指定重复次数的由元素组成的字符串对象。

String.prototype.replace()
    被用来在正则表达式和字符串直接比较，然后用新的子串来替换被匹配的子串。

String.prototype.search()
    对正则表达式和指定字符串进行匹配搜索，返回第一个出现的匹配项的下标。
String.prototype.slice()
    摘取一个字符串区域，返回一个新的字符串。

String.prototype.split()
    通过分离字符串成字串，将字符串对象分割成字符串数组。

String.prototype.startsWith()
    判断字符串的起始位置是否匹配其他字符串中的字符。

String.prototype.substr()
    通过指定字符数返回在指定位置开始的字符串中的字符。

String.prototype.substring()

    返回在字符串中指定两个下标之间的字符。
String.prototype.toLocaleLowerCase()
    根据当前区域设置，将符串中的字符转换成小写。对于大多数语言来说，toLowerCase的返回值是一致的。

String.prototype.toLocaleUpperCase()
    根据当前区域设置，将字符串中的字符转换成大写，对于大多数语言来说，toUpperCase的返回值是一致的。

String.prototype.toLowerCase()
    将字符串转换成小写并返回。

String.prototype.toSource()
    返回一个对象文字代表着特定的对象。你可以使用这个返回值来创建新的对象。重写 Object.prototype.toSource 方法。

String.prototype.toString()
    返回用字符串表示的特定对象。重写 Object.prototype.toString 方法。

String.prototype.toUpperCase()
    将字符串转换成大写并返回。

String.prototype.trim()
    从字符串的开始和结尾去除空格。参照部分 ECMAScript 5 标准。
String.prototype.trimStart()

String.prototype.trimLeft()
    从字符串的左侧去除空格。

String.prototype.trimEnd()
String.prototype.trimRight()
    从字符串的右侧去除空格。

String.prototype.valueOf()
    返回特定对象的原始值。重写 Object.prototype.valueOf 方法。

String.prototype[@@iterator]()
    返回一个新的迭代器对象，该对象遍历字符串值的索引位置，将每个索引值作为字符串值返回。 