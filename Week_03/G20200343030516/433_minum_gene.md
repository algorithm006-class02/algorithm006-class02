### description
433. 最小基因变化
一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。

假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。

例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。

与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

注意:

起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
所有的目标基因序列必须是合法的。
假定起始基因序列与目标基因序列是不一样的。
示例 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

返回值: 1
示例 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

返回值: 2
示例 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

返回值: 3

### solution
BFS
```python
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        genes = [ "A","G", "C", "T" ]
        newBank = set(bank)
        paths = [[start,0]]
        LEN = len(start)
        while paths:
            curState,count = paths.pop(0)
            if curState == end: return count
            for i in range(LEN):
                for gene in genes:
                    newGene = curState[:i] + gene + curState[i+1:]
                    if newGene in newBank:
                        paths.append([newGene,count+1])
                        newBank.remove(newGene)
        return -1
```

```javascript
/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(start, end, bank) {
    let bankSet = new Set(bank);
    if (!bankSet.has(end)) return -1;
    let queue = [[start, 0]];
    let dna = ["A", "C", "G", "T"];
    while (queue.length) {
        let [node, count] = queue.shift();
        if (node === end) return count;
        for (let i = 0; i < node.length; i++) {
            for (let j = 0; j < dna.length; j++) {
                let d = node.slice(0, i) + dna[j] + node.slice(i + 1);
                if (bankSet.has(d)) {
                    queue.push([d, count + 1]);
                    bankSet.delete(d);
                }
            }
        }
    }
    return -1;
};
```