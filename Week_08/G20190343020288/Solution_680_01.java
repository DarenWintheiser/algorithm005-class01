package week_08.commit;

// 680. 验证回文字符串 Ⅱ
// https://leetcode-cn.com/problems/valid-palindrome-ii/
public class Solution_680_01 {
    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r + 1) || isPalindromic(s, l - 1, r);
        return true;
    }

    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
}
