function hanmingWeight (n) {
    let count = 0;
    while (n != 0) {
        n &= n-1;
        count++;
    }
    return count;
}

let num = 00001111;
let res = hanmingWeight(num);
console.log(res)
