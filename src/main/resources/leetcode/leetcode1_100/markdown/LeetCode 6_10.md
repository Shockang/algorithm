# 前言

本文隶属于专栏《LeetCode 刷题汇总》，该专栏为笔者原创，引用请注明来源，不足和错误之处请在评论区帮忙指出，谢谢！

> 本专栏目录结构请见[LeetCode 刷题汇总](https://blog.csdn.net/Shockang/article/details/120599137)

# 正文

## 幕布
![在这里插入图片描述](https://img-blog.csdnimg.cn/0c7fc2f76e694e91bb95f7e9a34e5551.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAU2hvY2thbmc=,size_20,color_FFFFFF,t_70,g_se,x_16)

[幕布链接](https://www.mubucm.com/doc/Mr9vPcHGnn)

## 6. Z 字形变换

### 推荐

[官方题解](https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/)

### sb+几行+单次循环多长

```java
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 2) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int cycleLength = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLength) {
                result.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && (j + cycleLength - i) < n) {
                    result.append(s.charAt(j + cycleLength - i));
                }
            }
        }

        return result.toString();
    }
}
```

## 7. 整数反转
### 推荐

[官方题解](https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/)

### 不分正负，两次判断，大于 7 小于-8
```java
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }
}
```

## 8. 字符串转换整数 (atoi)

### 推荐

[Java Solution with 4 steps explanations](https://leetcode.com/problems/string-to-integer-atoi/discuss/4643/Java-Solution-with-4-steps-explanations)

### sign+单字符判断

```java
class Solution {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //1.trim
        str = str.trim();

        //2. Empty string
        if(str.length() == 0) return 0;

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
            if(Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
}
```

## 9. 回文数

### 推荐
![在这里插入图片描述](https://img-blog.csdnimg.cn/4a65c24e01334813a144109378647ac0.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAU2hvY2thbmc=,size_20,color_FFFFFF,t_70,g_se,x_16)

[官方题解](https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/)

### 中间折叠判断，x == rev || x==rev/10

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev){
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return x == rev || x == rev / 10;
    }
}
```

## 10. 正则表达式匹配

### 推荐
[【LeetCode 10. 正则表达式匹配】 每天一题刷起来！C++ 年薪冲冲冲！](https://www.bilibili.com/video/BV13441117i4)

### 递归，firstMatch，substring
```scala
object Solution {
  def isMatch(s: String, p: String): Boolean = {
    if (p.isEmpty) return s.isEmpty
    val firstMatch = !s.isEmpty && (s(0) == p(0) || p(0) == '.')
    if (p.length >= 2 && p(1) == '*') isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p))
    else firstMatch && isMatch(s.substring(1), p.substring(1))
  }
}
```

### 动态规划，有星无星，去两头还是去一头

```java
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 2; i <= n; i++){
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(p.charAt(j) == '*'){
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || (firstMatch(s, p, i, j - 1) && dp[i][j + 1]);
                }else{
                    dp[i + 1][j + 1] = firstMatch(s, p, i, j) && dp[i][j];
                }
            }
        }
        return dp[m][n];
    }

    private boolean firstMatch(String s, String p, int i, int j){
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }
}
```