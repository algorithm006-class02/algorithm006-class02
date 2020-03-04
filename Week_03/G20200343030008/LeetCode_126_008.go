//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则：
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
// 说明:
// 如果不存在这样的转换序列，返回一个空列表。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
// 示例 1:
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
//
// 示例 2:
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//输出: []
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
// Related Topics 广度优先搜索 数组 字符串 回溯算法

package main

func main() {

}

//leetcode submit region begin(Prohibit modification and deletion)
func findLadders(beginWord string, endWord string, wordList []string) [][]string {

	// 把 word 存入字典,用于快速查找
	dict := make(map[string]bool, len(wordList))
	for _, word := range wordList {
		dict[word] = true
	}
	// 快速退出
	if _, ok := dict[endWord]; !ok {
		return [][]string{}
	}
	delete(dict, beginWord)
	delete(dict, endWord)
	steps := map[string]int{beginWord: 1}
	parents := make(map[string][]string)
	queue := []string{beginWord}

	var res [][]string
	step := 0
	found := false

	for len(queue) > 0 && !found {
		step++
		size := len(queue)
		for i := size; i > 0; i-- {
			s := queue[0]
			queue = queue[1:]
			chs := []rune(s)
			for i := 0; i < len(beginWord); i++ { // 修改单词
				ch := chs[i]
				for c := 'a'; c <= 'z'; c++ {
					if c == ch { // 跳过自己
						continue
					}
					chs[i] = c
					t := string(chs)
					if t == endWord {
						parents[t] = append(parents[t], s)
						found = true
					} else {
						if v, ok := steps[t]; ok && step < v {
							parents[t] = append(parents[t], s)
						}
					}
					if _, ok := dict[t]; !ok {
						continue
					}
					// 访问过的单词去除
					delete(dict, t)
					steps[t] = steps[s] + 1
					queue = append(queue, t)
					parents[t] = append(parents[t], s)
				}
				// 未找到，恢复单词
				chs[i] = ch
			}
		}
	}
	if found { // 如果找到解了
		curr := []string{endWord} // 构建最后的目标单词
		getPaths(endWord, beginWord, parents, curr, &res)
	}
	return res
}

func getPaths(word, beginWord string, parents map[string][]string, curr []string, res *[][]string) {
	if word == beginWord {
		swap(curr)
		temp := make([]string, len(curr))
		copy(temp, curr)
		*res = append(*res, temp)
		swap(curr)
		return
	}
	for _, p := range parents[word] {
		curr = append(curr, p)
		getPaths(p, beginWord, parents, curr, res)
		curr = curr[:len(curr)-1]
	}
}

func swap(arr []string) {
	i, j := 0, len(arr)-1
	for i < j {
		arr[i], arr[j] = arr[j], arr[i]
		i, j = i+1, j-1
	}
}

//leetcode submit region end(Prohibit modification and deletion)
