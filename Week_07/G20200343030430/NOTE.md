学习笔记

### 排序代码

```javaScript
// 冒泡排序
const bubbleSort = (arr) => {
    if (arr.length <= 1) return
    for (let i = 0; i < arr.length; i++) {
        let hasChange = false
        for (let j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                const temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                hasChange = true
            }
        }
        // 如果false 说明所有元素已经到位
        if (!hasChange) break
    }
    console.log(arr)
}

// 插入排序
const insertionSort = (arr) => {
    if (arr.length <= 1) return
    for (let i = 1; i < arr.length; i++) {
        const temp = arr[i]
        let j = i - 1
        // 若arr[i]前有大于arr[i]的值的化，向后移位，腾出空间，直到一个<=arr[i]的值
        for (j; j >= 0; j--) {
            if (arr[j] > temp) {
                arr[j + 1] = arr[j]
            } else {
                break
            }
        }
        arr[j + 1] = temp
    }
    console.log(arr)
}

// 选择排序
const selectionSort = (arr) => {
    if (arr.length <= 1) return
    // 需要注意这里的边界, 因为需要在内层进行 i+1后的循环，所以外层需要 数组长度-1
    for (let i = 0; i < arr.length - 1; i++) {
        let minIndex = i
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j // 找到整个数组的最小值
            }
        }
        const temp = arr[i]
        arr[i] = arr[minIndex]
        arr[minIndex] = temp
    }
    console.log(arr)
}

const mergeArr = (left, right) => {
    let temp = []
    let leftIndex = 0
    let rightIndex = 0
    // 判断2个数组中元素大小，依次插入数组
    while (left.length > leftIndex && right.length > rightIndex) {
        if (left[leftIndex] <= right[rightIndex]) {
            temp.push(left[leftIndex])
            leftIndex++
        } else {
            temp.push(right[rightIndex])
            rightIndex++
        }
    }
    // 合并 多余数组
    return temp.concat(left.slice(leftIndex)).concat(right.slice(rightIndex))
}

// 归并排序
const mergeSort = (arr) => {
    // 当任意数组分解到只有一个时返回。
    if (arr.length <= 1) return arr
    const middle = Math.floor(arr.length / 2) // 找到中间值
    const left = arr.slice(0, middle) // 分割数组
    const right = arr.slice(middle)
    // 递归 分解 合并
    return mergeArr(mergeSort(left), mergeSort(right))
}


const swap = (arr, i, j) => {
    const temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

// 获取 pivot 交换完后的index
const partition = (arr, pivot, left, right) => {
    const pivotVal = arr[pivot]
    let startIndex = left
    for (let i = left; i < right; i++) {
        if (arr[i] < pivotVal) {
            swap(arr, i, startIndex)
            startIndex++
        }
    }
    swap(arr, startIndex, pivot)
    return startIndex
}

// 快速排序
const quickSort = (arr, left, right) => {
    if (left < right) {
        let pivot = right
        let partitionIndex = partition(arr, pivot, left, right)
        quickSort(arr, left, partitionIndex - 1 < left ? left : partitionIndex - 1)
        quickSort(arr, partitionIndex + 1 > right ? right : partitionIndex + 1, right)
    }

}
```

### 本周作业
掌握度 | index | level | desc | url
---|---|---|---|---
一般 | 190 | 简单 | 颠倒二进制位 | [reverse-bits](https://leetcode-cn.com/problems/reverse-bits)
熟悉 | 191 | 简单 | 位1的个数 | [number-of-1-bits](https://leetcode-cn.com/problems/number-of-1-bits)
熟悉 | 231 | 简单 | 2的幂 | [power-of-two](https://leetcode-cn.com/problems/power-of-two)
熟悉 | 1122 | 简单 | 数组的相对排序 | [relative-sort-array](https://leetcode-cn.com/problems/relative-sort-array)
一般 | 56 | 中等 | 合并区间 | [merge-intervals](https://leetcode-cn.com/problems/merge-intervals)
-- | 146 | 中等 | LRU缓存机制 | [lru-cache](https://leetcode-cn.com/problems/lru-cache)
-- | 493 | 困难 | 翻转对 | [reverse-pairs](https://leetcode-cn.com/problems/reverse-pairs)
-- | 52 | 困难 | N皇后 II | [n-queens-ii](https://leetcode-cn.com/problems/n-queens-ii)

### 课后作业
掌握度 | index | level | desc | url
---|---|---|---|---
-- | 338 | 中等 | 比特位计数 | [counting-bits](https://leetcode-cn.com/problems/counting-bits)

--：表示未做题目
