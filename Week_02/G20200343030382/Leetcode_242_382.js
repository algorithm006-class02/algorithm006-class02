/**
 * 242 有效的字母异位词
 * */

function isAnagram (s, t) {
    if (s.length != t.length) return false;
    let arr = [];
    for (let i = 0 ; i < s.length; i++) {
        arr[s[i]] ? arr[s[i]]++ : arr[s[i]] = 1;
    }

    for (let j = 0 ; j < t.length; j++) {
        if (arr[t[j]]) {
            arr[t[j]]--;
        } else{
            return false;
        }
    }

    return true;
}

let s = 'ate';
let t = 'eat';
let res = isAnagram(s, t)
console.log(res);

