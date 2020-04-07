# 学习笔记

## 小结

字符串的相关算法比较复杂，一般最外层的遍历少不了，关键在于内嵌的遍历优化

### 438

感觉自己用了滑动窗口，竟然超时了，训练营结束后继续查看

```golang
func sortString(w string) string {
	s := strings.Split(w, "")
	sort.Strings(s)
	return strings.Join(s, "")
}

func FindAnagrams(s string, p string) []int {
	var ans []int = make([]int, 0, len(s))
	var i int = 0
	var pSort string = sortString(p)
	var pl int = len(p)
	var end int = len(s) - pl + 1
	for ; i < end; i++ {
		if sortString(s[i:i+pl]) == pSort {
			ans = append(ans, i)
			//滑动窗口
			for ; i+pl < end; i++ {
				if s[i] == s[i+pl] {
					ans = append(ans, i+1)
				} else {
					break
				}
			}
		}
	}
	return ans
}
```
