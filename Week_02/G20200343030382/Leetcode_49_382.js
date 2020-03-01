/**
 * 字母异位词分组
 * */

function groupAnagrams (strs) {
    let hash = new Map();

    for (let i = 0; i < strs.length; i++) {
        let arr = Array(20).fill(0);
        let str = strs[i];
        for (let j = 0; j < str.length; j++) {
            arr[str[j].charCodeAt() - 97] ++;
        }
        let key = arr.join();
        if (hash.has(key)) {
            let temp = hash.get(key);
            temp.push(str);
            hash.set(key, temp);
        } else {
            hash.set(key, [str]);
        }
    }

    return [...hash.values()];
}

let strs = ["eat", "tea", "tan", "ate", "nat", "bat"];
let res = groupAnagrams(strs);
console.log(res);
