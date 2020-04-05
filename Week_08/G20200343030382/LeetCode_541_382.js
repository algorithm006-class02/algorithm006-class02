var reverseStr = function(s, k) {
    let len = s.length;
    let a = s.split('');
    if (len == 0) return '';
    for (let start = 0; start < len; start += 2 * k) {
        let i = start, j = Math.min(start + k - 1, len - 1);
        console.log(i,j)
        while (i < j) {
            let temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }
    return a.join("");
};
