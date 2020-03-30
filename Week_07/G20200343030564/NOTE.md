学习笔记

本周学习：

1.位运算
### 基础

|或运算：有1则为1

&与运算：两个为1才为1

~取反：0变1,1变0

**异或：相同的为0，不同的为1**。也可用“不进位加法”来理解。

异或操作的一些特点：

x ^ 0 = x

x ^ 1s(全1) = ~x

x ^ x = 0

c = a ^ b  --> a ^ c = b , b ^ a = c  //交换两个数

a ^ b ^ c = a ^ (b ^ c) = (a ^ b)  ^  c // associative



### 指定位置的位运算

1.将x最右边的n位清理：x & (~0 << n)

2.获取x的第n位值（0 或者 1）：（x >> n）& 1

3.获取x 的第n位的幂值：x & (1 << (n - 1))

4.仅将第n位置位1：x|(1<<n)

5.仅将第n位置位0：x&(~(1<<n))

6.将x最高位至第n位（含）清零：x & ((1<<n)-1)

7.将n最高位至第0位（含）清零：x & ((1<<(n+1))-1)



### 实战位运算要点

x % 2 == 1 --> (x & 1) == 1

x % 2 == 0 --> (x & 1) == 0



x >> 1 --> x / 2

即：x = x / 2;  --> x = x >> 1

mid = (left + right) / 2; --> mid = (left + right) >> 1;



x = x & (x - 1) 清零最低位的1

x & -x  --> 得到最低位的1

x & ~x  --> 0


N皇后问题：
```java
class Solution {
	private int size; 
	private int count;

private void solve(int row, int ld, int rd) { 
    if (row == size) { 
        count++; 
        return; 
    }
    int pos = size & (~(row | ld | rd)); 
    while (pos != 0) { 
        int p = pos & (-pos); 
        pos -= p; // pos &= pos - 1; 
        solve(row | p, (ld | p) << 1, (rd | p) >> 1); 
    } 
} 

public int totalNQueens(int n) { 
	count = 0; 
	size = (1 << n) - 1; 
	solve(0, 0, 0); 
	return count; 
  } 
}
``` 

2.布隆过滤器
一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中，
如果一个值经过几次哈希不在集合中就一定不在集合中，如果这个值经过映射在集合中，那这个值至
少有可能在集合中。

案例：
1.比特币网络
2.分布式系统--Hadoop、search engine
3.Redis缓存
4.垃圾邮件、评论等的过滤

3.排序算法

初级排序-O(n^2)
### 1.选择排序（Selection Sort）
每次找最小值，然后放到待排序数组的起始位置
```java
/**
 * 选择排序
 * 1.选择排序是否都是原地排序算法
 * 选择排序是原地排序算法，因为它只开辟了常量级的临时存储空间，所以空间复杂度为O(1)，所以它是原地算法
 * <p>
 * <p>
 * 2.选择排序是否是稳定的
 * 选择排序是查找未排序的集合中最小的和已排序的集合的最后一个进行比较，如果未排序集合中的最小值小于已排序中的最小值，则两个进行交换，当遇到
 * 相同的数字是不进行交换，那排序是稳定的。
 * <p>
 * <p>
 * 3.选择排序的时间复杂度和位移次数是多少
 * 假设集合n是逆序，则需要循环的次数是n-1 , n-2 .... 1 (n-1个数字)，所以时间复杂度是  n(n-1)/2  -->  O(n的平方)
 * 假设集合n是逆序，那要移动的次数是 n(n-1)/2 . 假设集合是正序，则满序度是 n(n-1)/2 ，则取中间值是  n(n-1)/4
 */
public class SelectionSort {

    /**
     * 倒序排序
     *
     * @param data 数值
     * @return
     */
    public int[] selectionSort(int[] data) {
        int length = data.length;
        if (data == null || length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            // 记录需要交换的下标
            int k = i;
            // 比较当前的和后面的数值谁大，记录小的位置
            for (int j = i + 1; j < length; j++) {
                if (data[k] > data[j]) {
                    k = j;
                }
            }
            if (k != i) {
                // 进行位置交换
                int temp = data[k];
                data[k] = data[i];
                data[i] = temp;
            }
        }
        return data;
    }
}
```
  
  
### 2.插入排序（Insertion Sort）
从前到后逐步构建有序序列；对于未排序数据，在已排序序列中以后向前扫描，
找到相应位置并插入
```java
/**
 * 插入排序
 * 1.插入排序是不是原地排序
 * 插入排序是原地排序算法，它只交换数值的位置，没有产生多余的空间
 * <p>
 * 2.插入排序的时间复杂度是多少，位移了多少
 * 最坏情况数组为倒序，第二个插到第一位，要移动一次，以此类推，第n个要插到第一位，要移动n-1次，所以时间复杂度为 (n-1)n/2 为o(n的平方)
 * 位移的数据是满有序度(n*(n-1)/2) - 初始有序度
 * <p>
 * 3.插入排序是否稳定
 * 如果设置相同的数值在插入时保持原有的顺序，则插入排序算法是稳定的
 */
public class InsertionSort {

    /**
     * 插入排序  从小到大
     *
     * @param data 数据
     * @return 排序后的数组
     */
    public int[] insertSort(int[] data) {
        int length = data.length;
        if (data == null || length == 0) {
            return null;
        }
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            // 获取出要插入的数值
            int value = data[i];
            for (; j >= 0; j--) {
                // 如果前面的数值大于插入的数值，都往后挪一位
                if (data[j] > value) {
                    data[j + 1] = data[j];
                } else {
                    // 如果前面的数比后面小，则不进行插入
                    break;
                }
            }
            // 把值插入到前面
            data[j + 1] = value;
        }
        return data;
    }
}
```

### 3.冒泡排序（Bubble Sort）
嵌套循环，每次查看相邻的元素如果逆序，则交换
```java
/**
 * 冒泡排序  优化版(记录交换次数)
 * <p>
 * 1.冒泡排序的时间复杂度和位移次数
 * 假设原来数值的顺序是完全倒序，假设有n数，第一个数要比较n-1次，依次递减，最后倒数第二个比较次数是1，最后一个不需要比较，所以总共比较的数为
 * n-1个，公式为(n-1+1)* n-1/2 得出 n(n-1)/2 去掉常数项和低阶，所以时间复杂度是O(n平方)
 * <p>
 * 因为每一个数值的位移次数都不一致，如果用概率论来计算过于复杂，所以引入有序度和逆序度概念，假设当数值的排序是(1,2,3,4,5,6)，为满序度为
 * n*(n-1)/2，假设数值排序是(6,5,4,3,2,1)，则逆序度是n*(n-1)/2，取他们的平均值为  n*(n-1)/4
 * <p>
 * 2.冒泡排序是不是稳定的
 * 冒泡排序是交换相邻的两个值，当两个值相同的时候，只要不改变它原来的循序，那它就是稳定的。
 * <p>
 * <p>
 * 3.冒泡排序是不是原地排序算法
 * 冒泡排序只需要交换两个数的值，开辟了常量集的临时空间，所以空间复杂度是O(1),是原地排序算法。
 */
public class BubbleSort {

    /**
     * 冒泡排序 从小到大
     *
     * @param data
     * @return
     */
    public int[] sort(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        int count = 0;
        int lastIndex = 0;
        int sortBorder = data.length - 1;
        for (int i = 0; i < data.length; i++) {
            // 默认没有交换
            boolean flag = true;
            for (int j = 0; j < sortBorder; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    // 有交换
                    flag = false;
                    count++;
                    // 记录最后交换的位置
                    lastIndex = j;
                }
            }
            sortBorder = lastIndex;
            System.out.println("交换边界：" + sortBorder);
            if (flag) {
                System.out.println("交换次数：" + count);
                break;
            }
        }
        return data;
    }
}
```

高级排序-O(NlogN)
## 快速排序（Quick sort）
  数组取标杆pivot,将小元素放pivot左边，大元素放右侧，然后依次对左边和右边的子数组
继续快排，已达到整个序列有序
```java
/**
 * 快速排序(
 * 优化排序
 * 1.选择前、中、后元素，判断三个元素中那个最小与第一个进行交换，再以第一个进行分界排序。
 * 2.如果数组的长度小于7，则使用插入排序，因为7以内插入排序性能很好。
 * 3.实现尾递归
 * ）
 */
public class QuickSort {

    public static int MAX_LENGTH_INSERT_SORT = 7;

    /**
     * 快速排序
     *
     * @param data 数组
     */
    private void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    /**
     * 递归调用
     *
     * @param data 数组
     * @param low  低位
     * @param high 高位
     */
    private void quickSort(int[] data, int low, int high) {
        if ((high - low) > MAX_LENGTH_INSERT_SORT) {
            while (low < high) {
                int point = partition(data, low, high);
                if (point - low < high - point) {
                    // 递归
                    quickSort(data, low, point - 1);
                    low = point + 1;
                } else {
                    // 递归
                    quickSort(data, point + 1, high);
                    high = point - 1;
                }
            }
        } else {
            inserSort(data, low, high);
        }
    }

    /**
     * 插入排序
     *
     * @param data 数组
     * @param low  低位
     * @param high 高位
     */
    private void inserSort(int[] data, int low, int high) {
        for (int i = low; i < high + 1; i++) {
            int j = i - 1;
            int value = data[i];
            for (; j >= 0; j--) {
                if (value < data[j]) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
    }

    /**
     * 分割
     *
     * @param data 数组
     * @param low  低位
     * @param high 高位
     * @return
     */
    private int partition(int[] data, int low, int high) {
        // 查找最小元素替换到第一个位置
        int temp = 0;
        // int middle = ( low + high ) / 2  值与下面的相等
        int middle = low + (high - low) / 2;
        if (data[low] > data[middle]) {
            temp = middle;
        }
        if (data[middle] > data[high]) {
            temp = high;
        }
        if (temp != 0) {
            swap(data, low, temp);
        }
        int point = data[low];
        while (low < high) {
            while (low < high && point <= data[high]) {
                high--;
            }
            swap(data, low, high);
            while (low < high && data[low] <= point) {
                low++;
            }
            swap(data, low, high);
        }
        return low;
    }

    /**
     * 交换元素
     *
     * @param data 数组
     * @param low  低位
     * @param high 高位
     */
    private void swap(int[] data, int low, int high) {
        int temp = data[low];
        data[low] = data[high];
        data[high] = temp;
    }
}

```

## 归并排序（Merge sort）--分治
 1.把长度为n的输入序列分为两个长度为n/2的子序列
 2.对这两个子序列分别采用归并排序
 3.将两个排序好的子序列合并成一个最终的排序序列
```java
/**
 * 归并排序
 */
public class MergeSort {

    /**
     * 归并排序 倒序
     *
     * @param data 数组
     * @return
     */
    public void mergeSort(int[] data, int left, int right) {
        // 递归结束条件，左边大于或者等于右边
        if (left < right) {
            int mid = (left + right) / 2;
            // 左边分解
            mergeSort(data, left, mid);
            // 右边分解
            mergeSort(data, mid + 1, right);
            // 合并
            merge(data, left, mid, right);

        }
    }

    /**
     * 合并分解数组
     *
     * @param data  源数据
     * @param left  左边节点
     * @param mid   中间节点
     * @param right 右边节点
     */
    private void merge(int[] data, int left, int mid, int right) {
        // 开辟临时空间,大小等于原来数组长度，防止经常扩容
        int[] temp = new int[data.length];
        // i 位置以左边的开始
        int i = left;
        int k = 0;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }
        // 遗留的左边数据
        while (i <= mid) {
            temp[k++] = data[i++];
        }
        // 遗留的右边数据
        while (j <= right) {
            temp[k++] = data[j++];
        }
        k = 0;
        //替换原来数组位置
        while (left <= right) {
            data[left++] = temp[k++];
        }
    }
}
```


## 堆排序（Heap Sort） --堆插入O(logN),取最大、最小值O(1)
1.数组元素依次建立小顶堆
2.依次取堆顶元素，并删除
```java
static void heapSort(int[] array){
  if(array.length==0)return;

  int length=array;length;
  for(int i=length/2-1;i>=0;i--){
    heapify(array,length,i);
  }

  for(int i=length-1;i>=0;i--){
    int temp=array[0];array[0]=array[i];array[i]=temp;
    heapify(array,i,0);
  }
}

static void heapify(int[] array,int length,int i){
    int left=2*i+1;right=2*i+2;
    int largest=i;

    if(left<length && array[left]>array[largest]){
        largest=leftChild;
    }
    if(right<length && array[right]> array[largest]){
        largest=right;  
    }
    if(largest != i){
       int temp=array[i];array[i]=array[largest];arr[largest]=temp;
       heapify(array,length,largest);
    }
}
```

## 特殊排序 O(n)
计数排序 （Counting Sort）
计数排序要求输入的数据必须是有确定范围的整数，将输入的数据值转化为键存储在额外开辟的数组
空间中；然后依次把技数大于1的填充回原数组；
```java
/**
 * 计数排序
 * <p>
 * 场景： 数据不大的时候，可以把数据划成多少个桶，省去了桶内排序时间
 * <p>
 * <p>
 * 设数组  A[8]  {2,5,3,0,2,3,0,3}
 * <p>
 * 假设新的数组C[]，数组的下标对应的是数组的数字，value是每个数字相加的总和
 * Max = A[i]，Max是A里面的最大值
 * C[Max + 1] = C[6]
 * C[6] {2 , 2 , 4 , 7 , 7 , 8}
 * 0   1   2   3   4   5
 * 假设数组R[]是排完数的数组
 */
public class CountingSort {

    private static int max = -1;

    public static int[] countingSort(int[] a) {
        // 查询A数组中的最大值作为C数组的大小
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        // 创建一个新数组C,Max+1的容量
        int[] c = new int[max + 1];

        // 计算每个数字的个数
        for (int i = 0; i < a.length; i++) {
            c[a[i]]++;
        }
        // 以数字为下标，value是每个数字的总和
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
            // C[6] {2 , 2 , 4 , 7 , 7 , 8}
            //       0   1   2   3   4   5
        }

        int[] r = new int[a.length];
        // 核心：把c数组下标迭代放入r数组中，位置是根据c数组下标对应的值，放入后，c为位置的值对应的减少一位直到为0
        for (int i = 0; i < a.length; ++i) {
            // 如果值是4，则对应数组中的下标是3
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 拷贝数组
        for (int i = 0; i < a.length; i++) {
            a[i] = r[i];
        }
        return a;
    }
}
```

## 桶排序（Bucket Sort）
假设输入的数据服从均匀分布，将数据分到有限数量的桶中，每个桶再分别进行排序（有可能再使用别的
排序算法或是以递归方式继续使用桶排序进行排）

## 基数排序（Radix Sort）
基数排序是按照低位先排序，然后收集；再按照高低排序，然后再收集；依次类推，直到最高位。有时候
有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
```java
/**
 * 基数排序
 * 时间复杂度：
 */
public class RadixSort {
    /**
     * 基数排序
     */
    private static void radixSort(int[] data, int d) {
        // 记录每一轮数组的位置
        int index = 0;
        // 对应的位数
        int n = 1;
        // 数组长度
        int length = data.length;
        // 排序桶(因为位数是不可能超过10，所以直接定义10)
        int[][] bucket = new int[10][length];
        // 记录每个桶存在多少个值
        int[] order = new int[length];
        while (n < d) {
            // 将数组里面的值分分配到对应的桶中
            for (int num : data) {
                // 计算位数
                int digit = (num / n) % 10;
                bucket[digit][order[digit]] = num;
                // 往后移动一位
                order[digit]++;
            }
            // 将结果覆盖到原数组中
            for (int i = 0; i < length; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        data[index] = bucket[i][j];
                        index++;
                    }
                }
                // 将计数位置为0，用于下一个排序
                order[i] = 0;
            }
            n = n * 10;
            index = 0;
        }
    }
}
```