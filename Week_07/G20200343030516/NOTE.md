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


### Sort
 > https://www.cnblogs.com/onepixel/p/7674659.html
1. 比较类元素
    > 通过比较决定元素之间的相对次序，时间复杂度大于O(nlogn)
2. 非比较类元素
    不通过比较元素间的相对次序
3.  相关概念
    > 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面。
    > 不稳定：如果a原本在b的前面，而a=b，排序之后 a 可能会 

#### bubble sort
+ 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
+ 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
+ 针对所有的元素重复以上的步骤，除了最后一个；
+ 重复步骤1~3，直到排序完成。

```javascript
function bubbleSort(arr){
    const len = arr.length;
    for(let i = 0; i < len-1; i++){
        boolean flag = false
        for(let j = 0; j< len -1 -i; j++){
            if(arr[j] > arr[j+1]){//swap
                let temp = arr[j+1]
                arr[j+1] = arr[j]
                arr[j] = temp
                flag = true
            }
        }
        if(!flag) break
    }
    return arr
}
```


#### 选择排序
选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。

```javascript
fucntion selectionSort(arr){
    const len = arr.length
    let minIndex,temp
    for( let i = 0;i<len-1; i++){
        minIndex = i
        for(let j = i+1;j <len -1 ;j++){
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
        }
        temp = arr[i]
        arr[i] = arr[minInndex]
        arr[minInndex] = temp
    }
    return arr
}
```

3.Insertion sort
插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
1. 从第一个元素开始，该元素可以认为已经被排序；
2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
5. 将新元素插入到该位置后；
重复步骤2~5。

```javascript
funtion insertionSort(arr){
    const len = arr.length;
    let preIndex = i-1;
    for(let i = 1; i<len; i++){
            preIndex = i-1;
            current = arr[i];
        while(preIndex >=0 && arr[preIndex] > current){
            arr[preIndex+1] = arr[preIndex]
            preIndex--;
        }
        arr[preIndex+1] = current;
    }
}
```
4. shell sort 
先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：

+ 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
+ 按增量序列个数k，对序列进行k 趟排序；
+ 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分+ 别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

```javascript
function shellSort(arr){
    const len = arr.length
    for(gap = Math.floor(len/2); gap > 0; gap =  Math.floor(gap / 2){
        for(vari = gap; i < len; i++) {
            varj = i;
            varcurrent = arr[i];
            while(j - gap >= 0 && current < arr[j - gap]) {
                 arr[j] = arr[j - gap];
                 j = j - gap;
            }
            arr[j] = current;
        }
    }
}
```

### 5.mergeSort
归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。 

```javascript
function mergeSort(arr){
    const len = arr.length
    if(len<2){
        return arr
    }
    const mid =  Math.floor(len/2)
    const left = arr.slice(0,mid)
    const right = arr.slice(midd)
    return merge(mergeSort(left),mergeSort(right));
}

function merge(left,right){
    let res = []
    while(left.length > 0 && right.length > 0){
        if(left[0] < right[0]){
            res.push(left.shift())
        }else{
            res.push(right.shift())
        }
    }
    while(left.length){
        res.push(left.shift())
    }
    while(right.length){
        res.push(right.shift())
    }
}

```
### 6、快速排序（Quick Sort）
快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

+ 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

+ 从数列中挑出一个元素，称为 “基准”（pivot）；
重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
+ 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

```javascript
fucntion quickSort(arr,left,right){
    const len = arr.length
    let partitionIndex
    left = typeof left !='number' ? 0 : left
    right = typeof right != 'number' ? len - 1 : right,

    if(left < right ){
        partitionIndex = partition(arr,left,right)
        quickSort(arr,left,partitionIndex -1)
        quickSort(arr,partitionIndex+1,right)
    }
    return arr
}

function parition(arr,left,right){
    const pivot = left
    let index = pivot +1
    for (let i = index; i < right; i++){
        if (arr[i] < arr[pivot]){
            swap(arr,i,index)
            index++
        }
    }
    swap(arr,pivot,index-1);
    return index-1
}
```