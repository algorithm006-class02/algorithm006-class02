package main

import (
	"fmt"
)

func main() {

	//words := []string{"oath","pea","eat","rain"}
	//board := [][]byte{[]byte{'o','a','a','n'}, []byte{'e','t','a','e'}, []byte{'i','h','k','r'}, []byte{'i','f','l','v'}}
	//words := []string{"a"}
	//board := [][]byte{[]byte{'a'}, []byte{'a'}}
	words := []string{"aba","baa","bab","aaab","aaa","aaaa","aaba"}
	board := [][]byte{[]byte{'a', 'b'}, []byte{'a', 'a'}}

	fmt.Println(findWords(board, words))
}

// O(k*l) + O(m*m-k) + O(k*2^l) m:board的长度 k:words非相同的前缀数量 l:words中最大word的长度
func findWords(board [][]byte, words []string) []string {

	row := len(board)
	if row == 0 || len(words) == 0 {
		return []string{}
	}

	tr := Constructor()
	for _, word := range words {
		tr.Insert(word)
	}

	col := len(board[0])

	resultMap := make(map[string]bool, len(words))
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			tmpVal := string(board[i][j])
			if tr.StartsWith(tmpVal) == true {
				dfs(tmpVal, tr, &board, i, j, &resultMap)
			}
		}
	}

	var result []string
	for word, _ := range resultMap {
		result = append(result, word)
	}

	return result
}


func dfs(currentWord string, tr Trie , board *[][]byte, row, col int, result *map[string]bool) {

	//recursion teminator
	if (*board)[row][col] == '@' || tr.StartsWith(currentWord) == false {
		return
	}

	//current logic
	if tr.Search(currentWord) == true {
		if _, ok := (*result)[currentWord]; !ok { //去重
			(*result)[currentWord] = true
		}
	}
	tmp := (*board)[row][col]
	(*board)[row][col] = '@'

	//drill down
	//上
	if row - 1 >= 0 {
		dfs(currentWord + string((*board)[row-1][col]), tr, board, row-1, col, result)
	}
	//下
	if row + 1 < len(*board) {
		dfs(currentWord + string((*board)[row+1][col]), tr, board, row+1, col, result)
	}
	//左
	if col - 1 >= 0 {
		dfs(currentWord + string((*board)[row][col-1]), tr, board, row, col-1, result)
	}
	//右
	if col + 1 < len((*board)[0]) {
		dfs(currentWord + string((*board)[row][col+1]), tr, board, row, col+1, result)
	}

	//clear current data status
	(*board)[row][col] = tmp
}


type TrieNode struct {
	links map[int32]*TrieNode
	isEnd bool
}

type Trie struct {
	root *TrieNode
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{root:&TrieNode{links:make(map[int32]*TrieNode)}}
}


/** Inserts a word into the trie. */
func (this *Trie) Insert(word string)  {
	currentNode := this.root
	for _, char := range word {
		if _, ok := currentNode.links[char-97]; !ok {
			currentNode.links[char-97] = &TrieNode{links:make(map[int32]*TrieNode)}
		}

		currentNode = currentNode.links[char-97]
	}

	currentNode.isEnd = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {

	node := this.searchPrefix(word)
	if node == nil {
		return false
	}

	return node.isEnd
}


/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {

	node := this.searchPrefix(prefix)
	if node == nil {
		return false
	}

	return true
}


func (this *Trie) searchPrefix(word string) *TrieNode {
	currentNode := this.root
	for _, char := range word {
		if _, ok := currentNode.links[char-97]; !ok {
			return nil
		}

		currentNode = currentNode.links[char-97]
	}

	return currentNode
}
