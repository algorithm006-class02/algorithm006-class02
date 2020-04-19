# Summary

## bubbling sort
```js
function bubblingSort(arr) {
  const len = arr.length
  for (let i = 0; i < len - 1; i++) {
    let needSwap = false
    for (let j = 0; j < len - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        const temp = arr[j]
        arr[j] = arr[j + 1]
        arr[j + 1] = temp
        needSwap = true
      }
    }
    if (!needSwap) break
  }
  return arr
}
```

## insertion sort 
```js
function insertionSort(a) {
  const len = a.length
  for (let i = 1; i < len; i++) {
    const val = a[i]
    let j = i - 1
    for (; j >= 0; j--) {
      if (a[j] > val) {
        a[j + 1] = a[j] // 移动数据
      } else {
        break
      }
    }
    a[j + 1] = val // 插入数据
  }
  return a
}
```

## count sort
```js
function bucketSort(...args) {
  const arr = new Array(10).fill(0) // M
  const ret = []
  for (let i = 0; i < args.length; i++) {
    // N
    arr[args[i]] += 1
  }

  // M + N
  for (let i = arr.length - 1; i >= 0; i--) {
    for (let j = 0; j < arr[i]; j++) {
      ret.push(i)
    }
  }

  return ret
}
```

## merge sort
```js
function mergeSort(a) {
  if (a.length < 2) return a

  const mid = Math.floor(a.length / 2)
  return merge(mergeSort(a.slice(0, mid)), mergeSort(a.slice(mid)))

  function merge(left, right) {
    const temp = []
    let i = 0
    let j = 0
    while (i < left.length && j < right.length) {
      if (left[i] > right[j]) {
        temp.push(right[j])
        j++
      } else {
        temp.push(left[i])
        i++
      }
    }
    return temp.concat(left.slice(i), right.slice(j))
  }
}
```

## quickly sort
```js
function quickS(a, start, end) {
  if (start >= end) return

  start = start || 0
  end = end || a.length - 1
  const pivot = a[end]

  let i = start
  let j = start
  for (; j < end; j++) {
    if (a[j] < pivot) {
      const temp = a[j]
      a[j] = a[i]
      a[i] = temp
      i++
    }
  }
  a[j] = a[i]
  a[i] = pivot

  quickS(a, start, i - 1)
  quickS(a, i + 1, end)

  return a
}
```