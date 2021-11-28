# 前言

本文隶属于专栏《LeetCode 刷题汇总》，该专栏为笔者原创，引用请注明来源，不足和错误之处请在评论区帮忙指出，谢谢！

> 本专栏目录结构请见[LeetCode 刷题汇总](https://blog.csdn.net/Shockang/article/details/120599137)

# 正文

## 幕布
![在这里插入图片描述](https://img-blog.csdnimg.cn/08916bff8a45473f8dd1a28f3e472cc7.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAU2hvY2thbmc=,size_20,color_FFFFFF,t_70,g_se,x_16)

[幕布链接](https://www.mubucm.com/doc/fuRPthpK3T)

## 11. 盛最多水的容器
### 题解
[官方题解](https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/)
### 双指针 left,right
```java
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int low = 0, high = height.length - 1;
        while (low < high) {
            maxArea = Math.max(maxArea, Math.min(height[low], height[high]) * (high - low));
            if (height[low] > height[high]) {
                high--;
            } else {
                low++;
            }
        }
        return maxArea;
    }
}

```

### 双指针 left,right,leftMax,rightMax
```java
class Solution {
    public int maxArea(int[] height) {
        int n = height.length, left = 0, right = n - 1, leftMax = 0, rightMax = 0, max = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(leftMax >= rightMax){
                right--;
            }else{
                left++;
            }
        }
        return max;
    }
}
```

## 12. 整数转罗马数字
### 题解
[My java solution easy to understand](https://leetcode.com/problems/integer-to-roman/discuss/6310/My-java-solution-easy-to-understand)
### 2个倒序数组，2个 while，sb

```java
class Solution {
    public String intToRoman(int num) {
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder res = new StringBuilder();
        int index = 0;
        while(index < 13){
            while(num >= nums[index]){
                res.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return res.toString();        
    }
}
```

## 13. 罗马数字转整数
### 题解

[Clean O(n) c++ solution](https://leetcode.com/problems/roman-to-integer/discuss/6547/Clean-O(n)-c%2B%2B-solution)
### map，4/9 特殊处理
```java
class Solution {
    Map<Character, Integer> symbolValues = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
```

## 14. 最长公共前缀

### 题解

[Java code with 13 lines](https://leetcode.com/problems/longest-common-prefix/discuss/6910/Java-code-with-13-lines)

### 先遍历第一个字符串，再嵌套整个数组，遇到不相等直接返回substring

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
```

## 15. 三数之和

### 题解

[Concise O(N^2) Java solution](https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution)

### 排序+双指针

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return new ArrayList<>(0);
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int a = nums[i], j = i + 1, k = n - 1;
            while(j < k){
                if(nums[j] + nums[k] + a == 0){
                    res.add(Arrays.asList(a, nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    j++;
                    while(j < k && nums[k] == nums[k - 1]){
                        k--;
                    }
                    k--;
                }else if(nums[j] + nums[k] + a < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
}
```