# 前言

本文隶属于专栏《LeetCode 刷题汇总》，该专栏为笔者原创，引用请注明来源，不足和错误之处请在评论区帮忙指出，谢谢！

> 本专栏目录结构请见[LeetCode 刷题汇总](https://blog.csdn.net/Shockang/article/details/120599137)

# 正文

## 幕布
![在这里插入图片描述](https://img-blog.csdnimg.cn/e9ee3f99a52f4208a5c1a8b25f976ed2.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAU2hvY2thbmc=,size_20,color_FFFFFF,t_70,g_se,x_16)
[幕布链接](https://www.mubucm.com/doc/5GIQ9R2-Zn)


## 1. 两数之和
### 推荐

[官方题解](https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/)
### map
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }else{
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}
```

## 2. 两数相加
### 推荐
[Java concise solution.](https://leetcode.com/problems/add-two-numbers/discuss/1044/Java-concise-solution.)
### 递归

```java
class Solution {
    private int carry;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return carry > 0 ? new ListNode(carry) : null;
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        carry = sum / 10;
        int val = sum % 10;
        ListNode res = l1 == null ? l2 : l1;
        res.val = val;
        res.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);
        return res;
    }
}
```

### 迭代
```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), node = dummy, cur;
        int carry = 0, sum;
        while (l1 != null || l2 != null || carry != 0) {
            cur = (l1 != null ? l1 : (l2 != null ? l2 : new ListNode(0)));
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            node.next = cur;
            node = cur;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return dummy.next;
    }
}
```

## 3. 无重复字符的最长子串

### 推荐

[11-line simple Java solution, O(n) with explanation](https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation)

### map
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, res = 0;
        for(int j = 0;j < s.length();j++){
            char cur = s.charAt(j);
            if(map.containsKey(cur)){
                i = Math.max(i, map.get(cur));
            }
            res = Math.max(res, j - i + 1);
            map.put(cur, j + 1);
        }
        return res;
    }
}
```

## 4. 寻找两个正序数组的中位数

### 推荐

[Hidden-超级无敌最小白式的解读又来了！](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/411176)

### 二分查找

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length, left = 0, right = m, leftTotal = (m + n + 1) / 2;

        while (left < right) {
            int i = left + ((right - left + 1) >> 1), j = leftTotal - i;

            if(nums1[i - 1] > nums2[j]){
                right = i - 1;
            }else{
                left = i;
            }
        }

        int i = left, j = leftTotal - i;

        int nums1LeftMax = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
        int nums1RightMin = (i == m ? Integer.MAX_VALUE : nums1[i]);
        int nums2LeftMax = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
        int nums2RightMin = (j == n ? Integer.MAX_VALUE : nums2[j]);
        if((m + n) % 2 == 0){
            return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
        }else{
            return (double)Math.max(nums1LeftMax, nums2LeftMax);
        }
    }
}
```

## 5. 最长回文子串
### 推荐
[官方题解-方法二：中心扩展算法](https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/)
### 奇偶 getLen

```java
class Solution {
    private char[] cs;
    private int n;
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        cs = s.toCharArray();
        n = s.length();
        String res = "";
        for(int i = 0; i < n - 1; i++){
            int len1 = getLen(i, i);
            int len2 = getLen(i, i + 1);
            if(len1 >= len2 && len1 > res.length()){
                res = s.substring(i - len1 / 2, i + 1 + len1 / 2);
            }else if(len1 < len2 && len2 > res.length()){
                res = s.substring(i + 1 - len2 / 2, i + 1 + len2 / 2);
            }
        }
        return res;
    }

    private int getLen(int l, int r){
        while(l >= 0 && r < n && cs[l] == cs[r]){
            l--;
            r++;
        }
        return r - l - 1;
    }
}
```