# Summary

## DP(dynamic programming)

- 寻找最优子结构（重复性）
- 状态的定义
- 状态转义方程

## 字符串算法

- Brute Force
- Rabin-Karp
- KMP
- Sliding Window

```cpp
unordered_map<char, int> window;
int left = 0;
int right = 0;
while (right < s.size()) {
  char c = s[right];
  window.add(c)
  right++;
  // logic
  while (window) {
    char c1 = s[left];
    window.remove(c1);
    left++;
    // logic
  }
}
```
