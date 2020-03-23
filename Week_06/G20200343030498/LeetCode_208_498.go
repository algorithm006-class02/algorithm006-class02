package main

import "fmt"

func main() {
	obj := Constructor()
	obj.Insert("android")
	obj.Insert("and")
	param_2 := obj.Search("android")
	fmt.Println(param_2)
	param_3 := obj.StartsWith("and")
	fmt.Println(param_3)

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

