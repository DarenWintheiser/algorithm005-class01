//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int[] limit = {0, 0};
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < ch.length) {
            i = indexOf(ch, i, limit);
        }
        result = s.substring(limit[0], limit[1]);
        return result;
    }

    public int indexOf(char[] ch, int low, int[] limit) {
        int high = low + 1;
        while (high < ch.length && ch[high] == ch[low]) {
            high++;
        }
        int result = high;
        while (low > 0 && high < ch.length && ch[low - 1] == ch[high]) {
            low--;
            high++;
        }

        if (high - low > limit[1] - limit[0]) {
            limit[0] = low;
            limit[1] = high;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
