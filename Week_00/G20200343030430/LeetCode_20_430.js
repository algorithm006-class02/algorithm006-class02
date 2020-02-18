/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if (!s) return true
    if (s.length % 2 == 1) return false

    let stack = []
    let pos = 0
    let top = ''
    for (let i = 0; i < s.length;) {
        let c = s[i]
        if (c == '(' || c == '[' || c == '{') {
            stack[pos++] = c
            top = c
            i++
        } else if (c == ')' && top == '(' || c == ']' && top == '[' || c == '}' && top == '{') {
            pos--
            top = stack[pos - 1]
            i++    
        } else {
            return false
        }
    }

    return !top
};