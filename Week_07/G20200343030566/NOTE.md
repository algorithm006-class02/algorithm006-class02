学习笔记
Bloom Filter vs Hash Table
一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中
优点：空间效率和查询时间都远远超过一般的算法
缺点：有一定的误识别率和删除困难
案例：
1.比特币网络
2.分布式系统--Hadoop、search engine
3.Redis缓存
4.垃圾邮件、评论等的过滤

Python 实现 Bloom Filter
from bitarray import bitarray
import mmh3

class BloomFilter:
  def __init__(self,size,hash_num):
    self.size=size;
    self.hash_num=hash_num;
    self.bit_array=bitarray(size);
    self.bit_array.setall(0)

  def add(self,s):
    for seed in range(self.hash_num):
	result=mmh3.hash(s,seed)% self.size
        self.bit_array[result]=1
  def lookup(self,s):
    for seed in range(self.hash_num):
	result=mmh3.hash(s,seed)&self.size
        if self.bit_array[result]==0:
	  return "Nope"
        return "Probably"

排序算法
比较类排序：
通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)
因此也称为非线性时间比较类排序

交换排序：冒泡排序 快速排序（重）
插入排序：简单插入排序 希尔排序
选择排序：简单选择排序 堆排序（重）
归并排序：二路归并排序 多路归并排序（重）
非比较类排序
不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，
以线性时间运行，因此也称为线性时间非比较类排序

计数排序 桶排序 基数排序

初级排序-O(n^2)
1.选择排序（Selection Sort）
  每次找最小值，然后放到待排序数组的起始位置
2.插入排序（Insertion Sort）
  从前到后逐步构建有序序列；对于未排序数据，在已排序序列中以后向前扫描，
找到相应位置并插入
3.冒泡排序（Bubble Sort）
  嵌套循环，每次查看相邻的元素如果逆序，则交换

高级排序-O(NlogN)
快速排序（Quick sort）
  数组取标杆pivot,将小元素放pivot左边，大元素放右侧，然后依次对左边和右边的子数组
继续快排，已达到整个序列有序

快速排序
public static void quickSort(int[] array,int begin,int end){
    if(end <= begin) return;
    int pivot = partition(array,begin,end);
    quickSort(array,begin,pivot-1);
    quickSort(array,pivot+1,end);
}
static int partition(int[] a,int begin,int end){
    // pivot:标杆位置，counter：小于pivot的元素的个数
    int pivot=end;count=begin;
    for(int i=begin;i<end;i++){
      if(a[i]<a[pivot]){
         int temp=a[counter];a[counter]=a[i];a[i]=temp;
         counter++;
      }	
    }
    int temp=a[pivot];a[pivot]=a[counter];a[counter]=temp;
    return counter;
}

归并排序（Merge sort）--分治
 1.把长度为n的输入序列分为两个长度为n/2的子序列
 2.对这两个子序列分别采用归并排序
 3.将两个排序好的子序列合并成一个最终的排序序列

归并排序
public static void mergeSort(int[] array,int left,int right){
    if(right<=left)return;
    int mid=(left+right)>>1;
    
    mergeSort(array,left,mid);
    mergeSort(array,mid+1,right);
    merge(array,left,mid,right);
}
static void merge(int[] array,int left,int mid,int right){
    int[] temp=new int[right-left+1];
    int i=left;j=mid+1,k=0;
    while(i<=mid && j<=right){
        temp[k++]=arr[i]<=arr[j] ? arr[i++]:arr[j++];
    }

    while(i<=mid) temp[k++]=arr[i++];
    while(j<=right) temp[k++]=arr[j++];

    for(int p=0;p<temp.length;p++){
        arr[left+p]=temp[p];
    }
}

归并和快排具有相似性，但步骤顺序相反
归并：先排序左右子数组，然后合并两个有序子数组
快排：先调配出左右子数组，然后对于左右子数组进行排序 

堆排序（Heap Sort） --堆插入O(logN),取最大、最小值O(1)
1.数组元素依次建立小顶堆
2.依次取堆顶元素，并删除

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

特殊排序 O(n)
计数排序 （Counting Sort）
计数排序要求输入的数据必须是有确定范围的整数，将输入的数据值转化为键存储在额外开辟的数组
空间中；然后依次把技数大于1的填充回原数组；

桶排序（Bucket Sort）
假设输入的数据服从均匀分布，将数据分到有限数量的桶中，每个桶再分别进行排序（有可能再使用别的
排序算法或是以递归方式继续使用桶排序进行排）

基数排序（Radix Sort）
基数排序是按照低位先排序，然后收集；再按照高低排序，然后再收集；依次类推，直到最高位。有时候
有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
