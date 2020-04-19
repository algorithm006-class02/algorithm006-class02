package main

import "fmt"

//UnionSet 并查集
type UnionSet struct {
	cap int
	set []int
}

//NewUnionSet function create UnionSet
func NewUnionSet(count int) *UnionSet {
	var cap int = count
	var set []int = make([]int, count)
	for i := 0; i < count; i++ {
		set[i] = i
	}
	return &UnionSet{cap: cap, set: set}
}

func (u *UnionSet) parent(i int) int {
	var root int = i
	for u.set[root] != root {
		root = u.set[root]
	}
	//路径压缩
	var cur int = i
	for u.set[cur] != cur {
		cur, u.set[cur] = u.set[cur], root
	}
	return root
}

func (u *UnionSet) union(i int, j int) {
	var pi int = u.parent(i)
	var pj int = u.parent(j)
	u.set[pi] = pj
}

func (u *UnionSet) countSet() int {
	var count = u.cap
	for i := 0; i < u.cap; i++ {
		if u.set[i] != i {
			count--
		}
	}
	return count
}

func main() {
	var demo [][]int = [][]int{
		{1, 1, 0},
		{1, 1, 0},
		{0, 0, 1},
	}
	var count int = len(demo)
	var u *UnionSet = NewUnionSet(count)
	for i := 0; i < count; i++ {
		for j := 0; j < i; j ++ {
			if demo[i][j] == 1 {
				u.union(i, j)
			}
		}
	}
	fmt.Println(u.countSet())
}
