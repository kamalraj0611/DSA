/*
Link - https://leetcode.com/problems/add-digits/description/
258. Add Digits
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

 

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0
 

Constraints:

0 <= num <= 231 - 1

  */

class Solution {

   /* 🔢 Digital Root Rule:
For any number num, the result after continuously adding digits is:

0 if num == 0

9 if num % 9 == 0

Otherwise num % 9

Examples:

38 → 3+8 = 11 → 1+1 = 2 → 38 % 9 = 2

18 → 1+8 = 9 → 18 % 9 = 0, but return 9.

So this is handled using:

(num == 0) → return 0  
(num % 9 == 0) → return 9  
else → return num % 9
*/

    public int addDigits(int num) {
        if(num == 0) return 0;
        return (num % 9 == 0) ? 9 : num % 9;
    }
}
