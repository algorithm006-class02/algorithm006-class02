//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
// 说明:
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
// 示例 1:
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//输出: 5
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
// 示例 2:
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//输出: 0
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索

package main

import "fmt"

func main() {

	fmt.Println(ladderLength("hit", "cog", []string{"hot", "dot", "dog", "lot", "log", "cog"}))
	fmt.Println(ladderLength("hit", "cog", []string{"hot", "dot", "dog", "lot", "log"}))

}

//leetcode submit region begin(Prohibit modification and deletion)
func ladderLength(beginWord string, endWord string, wordList []string) int {
	// 把 word 存入字典,用于快速查找
	dict := make(map[string]bool, len(wordList))
	for _, word := range wordList {
		dict[word] = true
	}
	// 快速退出
	if _, ok := dict[endWord]; !ok {
		return 0
	}
	var queue []string
	queue = append(queue, beginWord)

	l := len(beginWord)
	steps := 0

	for len(queue) > 0 {
		steps++
		size := len(queue)
		for i := size; i > 0; i-- {
			s := queue[0]
			queue = queue[1:]
			chs := []rune(s)
			for i := 0; i < l; i++ { // 修改单词
				ch := chs[i]
				for c := 'a'; c <= 'z'; c++ {
					if c == ch { // 跳过自己
						continue
					}
					chs[i] = c
					t := string(chs)
					if t == endWord {
						return steps + 1
					}
					if _, ok := dict[t]; !ok {
						continue
					}
					// 访问过的单词去除
					delete(dict, t)
					queue = append(queue, t)
				}
				// 未找到，恢复单词
				chs[i] = ch
			}
		}
	}
	return 0
}

//leetcode submit region end(Prohibit modification and deletion)
