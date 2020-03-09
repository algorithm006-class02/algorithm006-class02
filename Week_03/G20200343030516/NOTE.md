学习笔记
## week 03
 本周第一部分主要内容是有关分治，回溯
 其中分治算法也可以与递归算建立联系。

 以下是分治代码模板

 ```python
 def divide_conquer(problem,params):
    # 1  find the outpoint of the solution
    if getOut(problem):
        return
    
    ## prepare the data
    data = prepare_data(problem) 
    subproblems = split_problem(problem, data)


    ### split into little problem

    subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
    subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
    subresult3 = self.divide_conquer(subproblems[2], p1, ...) 

    #### process and generate the final result

    result = process_result(subresult1,subresult2)


    #### revert the current level states if changed in pre steps


 ```



### 搜索问题

dfs 可以写成递归的形式，
但是需要应用好最优解条件进行剪枝，来达到较快时间复杂度。
通过保存一些中间变量的结果，
dfs 还有地方需要进行回溯。



### 贪心算法
每一个subproblem最优，导致最后的total target 最优

### binary Search

代码模板
```python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

实际问题的变种
 + 变种1
找到第一个等于给定元素的值
```java

public int bsearch(int[] a, int n, int value) {
    int low = 0;
    int high = n-1;
    while(low <=high){
        int mid = low +((high -low)>>1);
        if(a[mid]>value) high = mid-1;
        else if(a[mid]<value) low = mid+1；
        else{
            if (mid == 0  || a[mid-1] < value) return mid;
            high = mid -1 ;
        }
    }
    return -1;
}
```

+ 变种2
找到最后一个等于给定元素的值
```java
public int bsearch(int[] a, int n, int value){
    int low = 0;
    int high = n-1;
    while(low <=high){
        int mid = low +((high -low)>>1);
        if(a[mid]>value) high = mid-1;
        else if(a[mid]<value) low = mid+1；
        else{
            if (mid == n-1  || a[mid+1] > value) return mid;
            low = mid +1 ;
        }
    }
    return -1;
}
```

+ 变种3 找到第一个大于等于该数的值
```java
public bSearch(int[] a, int n, int value){
    int low = 0;
    int high =  n-1;
    while(low<=high){
        int mid = low +((high-low)>>1);
        if(a[mid]>=value){
            if(mid == 0 || a[mid-1]<value) return mid;
            high = mid-1;
        }else{
            low = mid +1；
        }

    }
}
```
+ 变种4 找到第一个小于等于该数的值
```java
public bSearch(int[] a, int n, int value){
    int low = 0;
    int high =  n-1;
    while(low<=high){
        int mid = low +((high-low)>>1);
        if(a[mid]<=value){
            if(mid == n-1 || a[mid+1]>value) return mid;
            low = mid+ 1;
        }else{
            high = mid - 1；
        }

    }
}
```


 