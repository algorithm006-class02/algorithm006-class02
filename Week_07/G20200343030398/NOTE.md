# 学习笔记

## 小结

位运算更符合数据在计算机的内部表示方式，运算更高效
排序
非比较排序：基于整形 计数排序 桶排序 基数排序
比较类排序：更为通用 常用快速排序，归并排序

### 快速排序

```golang
func partition(arr []int, begin int, end int) int {
	var pivot int = end
	var counter int = begin
	for i := begin; i < end; i++ {
		if arr[i] < arr[pivot] {
			var temp int = arr[counter]
			arr[counter] = arr[i]
			arr[i] = temp
			counter++
		}
	}
	var temp = arr[pivot]
	arr[pivot] = arr[counter]
	arr[counter] = temp
	return counter
}

func quickSort(arr []int, begin int, end int) {
	if begin >= end {
		return
	}
	var pivot int = partition(arr, begin, end)
	quickSort(arr, begin, pivot-1)
	quickSort(arr, pivot+1, end)
}
```

### 归并排序

```golang
func merge(arr []int, left int, mid int, right int) {
	var helper []int = make([]int, 0, right-left+1)
	var i int = left
	var j int = mid + 1

	for (i <= mid) && (j <= right) {
		if arr[i] <= arr[j] {
			helper = append(helper, arr[i])
			i++
		} else {
			helper = append(helper, arr[j])
			j++
		}
	}

	for i <= mid {
		helper = append(helper, arr[i])
		i++
	}

	for j <= right {
		helper = append(helper, arr[j])
		j++
	}

	for p := 0; p < right-left+1; p++ {
		arr[left+p] = helper[p]
	}
}

func mergeSort(arr []int, left int, right int) {
	if left >= right {
		return
	}
	var mid int = (left + right) >> 1
	mergeSort(arr, left, mid)
	mergeSort(arr, mid+1, right)
	merge(arr, left, mid, right)
}
```