[Task Scheduler](https://leetcode.com/problems/task-scheduler/)  

```Python
from typing import List
from collections import Counter


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = Counter(tasks)
        max_task = max(count.values())
        nums = sum([1 for v in count.values() if v == max_task])
        res = (max_task - 1) * (n + 1) + nums
        return max(res, len(tasks))


if __name__ == '__main__':
    print(Solution().leastInterval(["A", "A", "A", "B", "B", "B"], 2))
```
