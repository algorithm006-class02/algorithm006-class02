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
 