/*
Link - https://www.geeksforgeeks.org/problems/sum-of-digit-is-pallindrome-or-not2751/1
Sum of Digit is Palindrome or not
Difficulty: BasicAccuracy: 45.75%Submissions: 69K+Points: 1
Given a number n. Return true if the digit sum(or sum of digits) of n is a Palindrome number otherwise false.

A Palindrome number is a number that stays the same when reversed

Examples:

Input: n = 56
Output: true
Explanation: The digit sum of 56 is 5+6 = 11. Since, 11 is a palindrome number.Thus, answer is true.
Input: n = 98
Output: false
Explanation: The digit sum of 98 is 9+8 = 17. Since 17 is not a palindrome,thus, answer is false.
Constraints:
1 <= n <= 109

Expected Complexities
Time Complexity: O(log n)
Auxiliary Space: O(1)
*/

// User function Template for Java

class Solution {
    boolean isDigitSumPalindrome(int n) {
        // code here
        int DigitSum = 0; 
        while(n > 0)
        {
            DigitSum += n % 10;
            n /= 10;
        }
        return isPalindrome(DigitSum);
        
    }
    
    private boolean isPalindrome(int input)
    {
        int original= input, reversed= 0;
        while(input > 0)
        {
            reversed *= 10;
            reversed += input % 10;
            input /= 10;
        }
        
        return original == reversed ? true : false;
    }
}
