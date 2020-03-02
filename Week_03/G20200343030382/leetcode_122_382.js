let prices = [7, 1, 5, 3, 6, 4];
function maxProfit (prices) {
    let res = 0;
    for (let i = 0; i < prices.length; i++) {
        if(prices[i + 1] - prices[i] > 0 ){
            res += prices[i + 1] - prices[i];
        }
    }
    return res;
}

console.log(maxProfit(prices))
