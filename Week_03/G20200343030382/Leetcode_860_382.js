let bills = [5, 5, 10, 20];

function lemonadeChane (bills) {
    let ten = 0;
    let five = 0;
    for (let i = 0; i< bills.length; i++) {
        if(bills[i] == 5) {
            five += 1;
        }else if(bills[i] == 10) {
            five -= 1;
            ten += 1;
        }else {
            if (ten && five) {
                five -= 1;
                ten -= 1;
            } else if(five >= 3) {
                five -= 3;
            } else {
                return false;
            }
        }
    }
    return true;
}

console.log(lemonadeChane(bills));
