//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
//
//
// 示例:
//
// 输入:
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"]
//
// 说明:
//你可以假设所有输入都由小写字母 a-z 组成。
//
// 提示:
//
//
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
//
// Related Topics 字典树 回溯算法

package main

func main() {

}

//leetcode submit region begin(Prohibit modification and deletion)

func findWords(board [][]byte, words []string) []string {
	var results []string

	m := len(board)
	if m == 0 {
		return results
	}

	n := len(board[0])
	if n == 0 {
		return results
	}

	trie := buildTrie(words)

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			dfs(board, i, j, trie, &results)
		}
	}

	return results
}

func dfs(board [][]byte, i int, j int, trie *TrieNode, results *[]string) {
	c := board[i][j]
	if c == '#' || trie.next[int(c-'a')] == nil {
		return
	}

	trie = trie.next[int(c-'a')]
	if len(trie.word) > 0 {
		// Found one
		*results = append(*results, trie.word)
		trie.word = ""
	}

	board[i][j] = '#'
	if i > 0 {
		dfs(board, i-1, j, trie, results)
	}

	if i < len(board)-1 {
		dfs(board, i+1, j, trie, results)
	}

	if j > 0 {
		dfs(board, i, j-1, trie, results)
	}

	if j < len(board[0])-1 {
		dfs(board, i, j+1, trie, results)
	}

	board[i][j] = c
}

func buildTrie(words []string) *TrieNode {
	root := new(TrieNode)
	for _, word := range words {
		cur := root
		for _, c := range word {
			cidx := int(c - 'a')
			if cur.next[cidx] == nil {
				cur.next[cidx] = new(TrieNode)
			}
			cur = cur.next[cidx]
		}
		cur.word = word
	}

	return root
}

// TrieNode 是 trie 的节点
type TrieNode struct {
	next [26]*TrieNode
	word string
}

//leetcode submit region end(Prohibit modification and deletion)
