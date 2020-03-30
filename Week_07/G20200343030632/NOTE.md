## 学习笔记
### 位运算相关运算

- 基本位运算: 左移<<, 右移>>, 按位或|, 按位与&, 按位异或^, 按位取反~
- 常用位运算:
    - 判断奇偶(取最低位): x & 1 == 1(奇), x & 1 == 0(偶)
    - 清零最低位的1: x = x & (x - 1) 
    - 得到最低位的1: res = x & ~x
    - x & -x = 0
- 异或的一些操作:
    - x ^ 0 = x
    - x ^ 1s = ~ x (1s = ~0)
    - x ^ ~x = 1s
    - x ^ x = 0
    - 交换两个数a, b: c = a ^ b, a ^ c = b, b ^ c = a
    - 结合律: a ^ b ^ c = (a ^ b) ^ c = a ^ (b ^ c)

- 指定二进制位的常用操作:
    - 将x最右边的n位清零: x & (~0 << n)
    - 获取x的第n位的值: (x << n) & 1
    - 获取x的第n位的幂值: x & (1 << (n - 1))
    - 仅将第n位置变为1: x | (1 << n)
    - 仅将第n位置变为0: x & (~(1 << n))
    - 将x的最高位到第n位置清零: x & ((1 << n) - 1)
    - 将第n位至第0位清零: x & (~((1 << (n + 1) - 1))

### 排序相关

#### 十种基本排序
![avatar](https://images2018.cnblogs.com/blog/849589/201804/849589-20180402133438219-1946132192.png)
参考[这个链接](https://www.cnblogs.com/onepixel/p/7674659.html)    

#### 快速排序代码:
- Java
```
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}

static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
}

```
- Python
```
def partition(arr,low,high): 
    i = low - 1   
    pivot = arr[high]
  
    for j in range(low , high): 
        if   arr[j] < pivot: 
            i = i + 1 
            arr[i], arr[j] = arr[j], arr[i] 
  
    arr[i+1], arr[high] = arr[high], arr[i+1] 
    return i + 1 
  
def quickSort(arr, low, high): 
    if low < high: 
        pi = partition(arr, low, high) 
        quickSort(arr, low, pi-1) 
        quickSort(arr, pi+1, high) 
```

#### 归并排序代码:
- Java
```
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        // 也可以用 System.arraycopy(a, start1, b, start2, length)
    }
```
- Python
```
def merge(arr, l, m, r): 
	n1 = m - l + 1
	n2 = r- m 

	# create temp arrays 
	L = [0] * (n1) 
	R = [0] * (n2) 

	# Copy data to temp arrays L[] and R[] 
	for i in range(0 , n1): 
		L[i] = arr[l + i] 

	for j in range(0 , n2): 
		R[j] = arr[m + 1 + j] 

	# Merge the temp arrays back into arr[l..r] 
	i = 0	 # Initial index of first subarray 
	j = 0	 # Initial index of second subarray 
	k = l	 # Initial index of merged subarray 

	while i < n1 and j < n2 : 
		if L[i] <= R[j]: 
			arr[k] = L[i] 
			i += 1
		else: 
			arr[k] = R[j] 
			j += 1
		k += 1

	# Copy the remaining elements of L[], if there 
	# are any 
	while i < n1: 
		arr[k] = L[i] 
		i += 1
		k += 1

	# Copy the remaining elements of R[], if there 
	# are any 
	while j < n2: 
		arr[k] = R[j] 
		j += 1
		k += 1

# l is for left index and r is right index of the 
# sub-array of arr to be sorted 
def mergeSort(arr,l,r): 
	if l < r: 

		# Same as (l+r)/2, but avoids overflow for 
		# large l and h 
		m = (l+(r-1))/2

		# Sort first and second halves 
		mergeSort(arr, l, m) 
		mergeSort(arr, m+1, r) 
		merge(arr, l, m, r) 
```