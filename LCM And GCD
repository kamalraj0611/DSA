/*LCM And GCD
Link - https://www.geeksforgeeks.org/problems/lcm-and-gcd4516/1
Difficulty: BasicAccuracy: 37.02%Submissions: 217K+Points: 1
Given two integers a and b, the task is to compute their LCM and GCD and return an array containing their LCM and GCD.

Examples:

Input: a = 5 , b = 10
Output: [10, 5]
Explanation: LCM of 5 and 10 is 10, while their GCD is 5.
Input: a = 14 , b = 8
Output: [56, 2]
Explanation: LCM of 14 and 8 is 56, while their GCD is 2.
Input: a = 1 , b = 1
Output: [1, 1]
Explanation: LCM of 1 and 1 is 1, while their GCD is 1.
Constraints:
1 <= a, b <= 109

Expected Complexities
Time Complexity: O(log(min(a, b))
Auxiliary Space: O(1)*/


// User function Template for Java

class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int gcd= calculateGCD(a, b);
        int lcm = a/ gcd *b;
        return new int[] {lcm,  gcd};
        
    }
    
    public static int calculateGCD(int x, int y)
    {
        return (y==0) ? x : calculateGCD(y, x%y);
    }
}
