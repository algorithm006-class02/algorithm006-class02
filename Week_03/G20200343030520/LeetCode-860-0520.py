from typing import List

class Solution:
    """ At a lemonade stand, each lemonade costs $5. 
        Customers are standing in a queue to buy from you, 
        and order one at a time (in the order specified by bills).
        Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  
        You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
        Note that you don't have any change in hand at first.
        Return true if and only if you can provide every customer with correct change.

        Example 1:

            Input: [5,5,5,10,20]
            Output: true
            Explanation: 
            From the first 3 customers, we collect three $5 bills in order.
            From the fourth customer, we collect a $10 bill and give back a $5.
            From the fifth customer, we give a $10 bill and a $5 bill.
            Since all customers got correct change, we output true.
 
    """
    def lemonadeChange(self, bills):
        five = ten = 0

        for bill in bills:
            if bill == 5:
                five += 1

            elif bill == 10:
                if not five: return False
                five -= 1
                ten += 1

            else:
                if ten and five:
                    ten -= 1
                    five -= 1
                elif five >= 3:
                    five -= 3
                else:
                    return False

        return True

if __name__ == "__main__":
    pass
        