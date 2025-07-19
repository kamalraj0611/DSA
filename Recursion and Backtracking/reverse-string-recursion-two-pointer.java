/*
https://leetcode.com/problems/reverse-string/description/
344. Reverse String
Solved
Easy
Topics
premium lock icon
Companies
Hint
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.
  */

class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        reverseStringHelper(s,0, n-1);
    }

     public void reverseStringHelper(char[] s, int left, int right) {
        if(left>=right) return;
        char temp = s[left];
        s[left] = s[right];
         s[right] = temp;
         
         reverseStringHelper(s, left+1, right-1);
        }
}
