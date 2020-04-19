学习笔记

冒泡排序
vector<int> bubbleSort(vector<int> arr) {
    int len = arr.size();
    for (int i=0; i<len-1; i++) {
        for (int j=0; j<len-1-i; j++) {
            if (arr[j]>arr[j+1]) {          // 相邻元素两两对比
                int temp = arr[j+1];        // 元素交换
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}

选择排序
vector<int> selectionSort(vector<int> arr) {
    int len = arr.size();
    int minIndex, temp;
    for (int i=0; i<len-1; i++) {
        minIndex = i;
        for (int j=i+1; j<len; j++) {
            if (arr[j]<arr[minIndex]) {       // 寻找最小的数
                minIndex = j;                 // 将最小数的索引保存
            }
        }
        temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
    return arr;
}

插入排序
vector><int> insertionSort(vector><int> arr) {
    int len = arr.size();
    int preIndex, current;
    for (int i=1; i<len; i++) {
        preIndex = i - 1;
        current = arr[i];
        while (preIndex>=0 && arr[preIndex]>current) {
            arr[preIndex+1] = arr[preIndex];
            preIndex--;
        }
        arr[preIndex+1] = current;
    }
    return arr;
}