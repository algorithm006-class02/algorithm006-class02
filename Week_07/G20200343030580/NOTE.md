学习笔记

### 插入排序

````
public static void insertionSort(int[] data) {
    for (int i = 1; i < data.length; i++) {
        int insertIndex = i;
        for (int j = 0; j < i; j++) {
            if (data[j] > data[i]) {
                insertIndex = j;
                break;
            }
        }
        int current = data[i];
        for (int k = i; k > insertIndex; k--) {
            data[k] = data[k - 1];
        }
        data[insertIndex] = current;
    }
}

````

### 希尔排序
````
public static void shellSort(int[] data) {
    int step = data.length / 2;
    while (step >= 1) {
        for (int i = step; i < data.length; i++) {
            int value = data[i];
            int j = i - step;
            for (; j >= 0; j -= step) {
                if (value < data[j]) {
                    data[j + step] = data[j];
                } else {
                    break;
                }
            }
            data[j + step] = value;
        }
        step = step / 2;
    }
}
````

### 选择排序

````
public static void selectionSort(int[] data) {
    for (int i = 0; i < data.length - 1; i++) {
        int minIndex = i;
        for (int j = i; j < data.length; j++) {
            if (data[j] < data[minIndex]) {
                minIndex = j;
            }
        }
        int tmp = data[i];
        data[i] = data[minIndex];
        data[minIndex] = tmp;
    }
}

````

### 堆排序
````
public static void heapSort(int[] data) {
    if (data.length == 0) {
        return;
    }
    int length = data.length;
    for (int i = length / 2 - 1; i >= 0; i--) {
        heapify(data, length, i);
    }
    for (int i = length - 1; i >= 0; i--) {
        int tmp = data[0];
        data[0] = data[i];
        data[i] = tmp;
        heapify(data, i, 0);
    }
}

private static void heapify(int[] data, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2;
    int largest = i;
    if (left < length && data[left] > data[largest]) {
        largest = left;
    }
    if (right < length && data[right] > data[largest]) {
        largest = right;
    }
    if (largest != i) {
        int tmp = data[i];
        data[i] = data[largest];
        data[largest] = tmp;
        heapify(data, length, largest);
    }
}

````

### 冒泡排序

````
public static void bubbleSort(int[] data) {
    for (int i = 0; i < data.length - 1; i++) {
        for (int j = i; j < data.length; j++) {
            if (data[i] > data[j]) {
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }
        }
    }
}

````

### 快速排序

````
public static void quickSort(int[] data) {
    quickSort(data, 0, data.length - 1);
}

private static void quickSort(int[] data, int left, int right) {
    if (right <= left) {
        return;
    }
    int p = partition(data, left, right);
    quickSort(data, left, p - 1);
    quickSort(data, p + 1, right);
}

private static int partition(int[] data, int left, int right) {
    int pivot = right, counter = left;
    for (int i = left; i < right; i++) {
        if (data[i] < data[pivot]) {
            int tmp = data[i];
            data[i] = data[counter];
            data[counter] = tmp;
            counter++;
        }
    }
    int tmp = data[pivot];
    data[pivot] = data[counter];
    data[counter] = tmp;
    return counter;
}

````

### 归并排序

````
public static void mergeSort(int[] data) {
    mergeSort(data, 0, data.length - 1);
}


private static void mergeSort(int[] data, int left, int right) {
    if (right <= left) {
        return;
    }
    int mid = (left + right) >> 1;
    mergeSort(data, left, mid);
    mergeSort(data, mid + 1, right);
    merge(data, left, mid, right);
}

private static void merge(int[] data, int left, int mid, int right) {
    int[] tmp = new int[right - left + 1];
    int i = left, j = mid + 1, index = 0;
    while (i <= mid && j <= right) {
        tmp[index++] = data[i] < data[j] ? data[i++] : data[j++];
    }
    if (i <= mid + 1) {
        System.arraycopy(data, i, tmp, index, mid - i + 1);
    }
    if (j <= right) {
        System.arraycopy(data, j, tmp, index, right - j + 1);
    }
    System.arraycopy(tmp, 0, data, left, tmp.length);
}
````