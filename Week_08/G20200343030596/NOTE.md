学习笔记
一、高级动态规划
动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构）

拥有共性：找到重复子问题

差异性：最优子结构、中途可以淘汰次优解

二、字符串

1.Java表示字符串：
String x = "abbc"; 不可变

2.遍历字符串
String x = "abbc";
for (int i = 0; i < x.size(); i++){
char ch = x.charAt(i);
}

for ch in x.toCharArray(){
sout(ch);
}

3.字符串比较
String x = "abb";
String y = "abb";

x==y ——>false

x.equals(y) ——>true

x.equalsIgnoreCase(y)——>true

三、字符串高级

1.最长子串、子序列（子序列可以有间隔，子串没有）

最长子序列
dp[i][j] = dp[i-1][j-1] + 1(if s1[i-1] == s2[j-1])
else dp[i][j] = max(dp[i-1][j],dp[i][j-1])

最长子串
dp[i][j] = dp[i-1][j-1] + 1(if s1[i-1]==s2[j-1])
else dp[i][j] = 0

编辑距离

2.回文串子串

1.暴力O(n^3)
2.中间向两边扩张法O(n^2)
3.动态规划
首先定义P(i,j):
    P(i,j)= true s[i,j]是回文串
            false s[i,j]不是回文串
接下来
P(i,j) = (P(i+1,j-1)&&s[i]==s[j])
            

三、字符串匹配算法
1.暴力法（brute force） ——O(mn)

public static int forceSearch(String txt, String pat){
    int M = txt.length();
    int N = pat.length();
    for(int i = 0;i <= M-N;i++){
        int j;
        for(j = 0;j < N;j++){
            if(txt.charAt(i+j) != pat.charAt(j)
                break;
                
        }
        if(j == N){
            return i;
        }
        //1.预先判断 hash(txt.substring(i,M)) == hash(pat)
        //2.KMP 已经匹配的片段，它最大的前缀和最大的后缀，最长有多长
    }
    return -1;
}

2.Rabin-Karp算法

暴力算法中我们挨个比较所有字符，才知道目标字符串中是否包含子串。所以优化判断目标字符串包含子串的过程

我们尝试一次性判断两者是否相等。因此，我们需要一个好的哈希函数。通过哈希函数，我们可以算出子串的哈希值，然后将它和目标字符串中的子串的哈希值进行比较

public final static int D = 256;
public final static int Q = 9997;

public static int RabinKarpSearch(String txt,String pat){
    int M = pat.length();
    int N = txt.length();
    int i,j;
    int patHash = 0,txtHash = 0;
    
    for(i = 0;i < M;i++){
        patHash = (D * patHash + pat.charAt(i) % Q);
        txtHash = (D * txtHash + txt.charAt(i) % Q);
    }
    
    int highestPow = 1;
    for(i = 0;i < M-1;i++){
        highestPow = (highestPow * D) % Q;
    }
    
    for(i = 0;i < N-M;i++){
        if(patHash == txtHash){
            for(j = 0;j < M;j++){
                if(txt.charAt(i+j)!=pat.charAt(j))
                    break;
            }
            if(j == M)
                return i;
        }
        if(i < N-M){
            txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i+M)) %Q;
            if(txtHash < 0)
                txtHash += Q;
        }
    }
    return -1;
}

3.KMP算法

第一步生成前缀表(找最长公共前缀后缀长度)
第二步根据前缀表来完成整个KMP的搜索

P表示要匹配的字符串 ABABCABAA
前缀表为：0,0,1,2,0,1,2,3,1

前缀：除了最后一个字符外，一个字符串的全部头部组合
abc:a,ab

后缀：除了第一个字符以外，一个字符串的全部组合
abc:c,bc

A 0

AB 0

ABA 1 这里1是 AB 和 BA所以不行

ABAB 2

ABABC 0

ABABCA 1

ABABCAB 2

ABABCABA 3（ABA ABA)

ABABCABAA 1 最后一个不用看

void prefix_table(char pattern[], int prefix[], int n){
    prefix[0] = 0;
    int len = 0;
    int i = 1;
    while (i < n){
        if(pattern[i] == pattern[len]){
            len++;
            prefix[i] = len;
            
        }else{
            if(len > 0){
                len = prefix[len-1];
            }else{
                prefix[i] = len;
                i++;
            }
        }
    }
}

void move_prefix_table(int prefix[], int n){
    int i ;
    for(i = n -1;i > 0;i--){
        prefix[i] = prefix[i-1];
    }
    prefix[0] = -1;
}

void kmp_search(char text[], char pattern[]){
    int n = pattern.length;
    int m = text.length;
    int[] prefix = new int[n];
    prefix_table(pattern, prefix, n);
    move_prefix_table(prefix, n);
    
    //test[i] ,len(text) = m
    //pattern[j],len(pattern) = n
    int i = 0,j = 0;
    while(i < m){
        if(j == n-1 && text[i] == pattern[j]){
            sout(i-j);
            j = prefix[j];
        }
        if(text[i] == pattern[j]){
            i++;j++;
        }else{
            j = prefix[j];
            if(j == -1){
                i++;j++;
            }
        }
    }
}
