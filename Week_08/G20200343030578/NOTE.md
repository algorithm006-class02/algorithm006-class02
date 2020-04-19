学习笔记

高级 DP

* 多维状态数组
* 复杂的状态转移方程

字符串

* Atoi

```java
public int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    //1. Empty string

    if(str.length() == 0) return 0;
    //2. Remove Spaces

    while(str.charAt(index) == ' ' && index < str.length())
        index ++;
    //3. Handle signs

    if(str.charAt(index) == '+' || str.charAt(index) == '-'){
        sign = str.charAt(index) == '+' ? 1 : -1;
        index ++;
    }


    //4. Convert number and avoid overflow

    while(index < str.length()){
        int digit = str.charAt(index) - '0';
        if(digit < 0 || digit > 9) break;
        //check if total will be overflow after 10 times and add digit

        if(Integer.MAX_VALUE/10 < total ||

           Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        total = 10 * total + digit;
        index ++;
    }
    return total * sign;
}
```

* 字符串反转
* Anagram异位词
* Palindrome 回文串问题
* 最长子串、子序列
  * 最长子序列
  * 最长子串
  * 编辑距离

* 字符串匹配算法
  * Rabin-Karp 算法
    * Rabin-Karp 算法的思想： 
      1. 假设子串的长度为 M (pat)，目标字符串的长度为 N (txt) 
      2. 计算子串的 hash 值 hash_pat 
      3. 计算目标字符串txt中每个长度为 M 的子串的 hash 值（共需要计算 N-M+1
         次） 
      4. 比较 hash 值：如果 hash 值不同，字符串必然不匹配; 如果 hash 值相同，
         还需要使用朴素算法再次判断
  * KMP 算法
    * KMP算法（Knuth-Morris-Pratt）的思想就是，当子串与目标字符串不匹配时，
      其实你已经知道了前面已经匹配成功那 一部分的字符（包括子串与目标字符
      串）。设法利用这个已知信息，不要把“搜索位
      置” 移回已经比较过的位置，继续把它向后移，这样就提高了效率。