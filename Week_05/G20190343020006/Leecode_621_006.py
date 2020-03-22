class Solution(object):
    def leastInterval(self, tasks, n):
        length = len(tasks)
        task_map = {}
        for task in tasks:
            task_map[task] = tasks.get(task,0) + 1
        task_sort = sorted(task_map.items(), key=lambda x:x[1], reverse=True)
        max_task_count = task_sort[0][1]
        res = (max_task_count - 1) * (n + 1)
        for sort in task_sort:
            if sort[1] == max_task_count:
                res += 1
        return res if res < length else length
