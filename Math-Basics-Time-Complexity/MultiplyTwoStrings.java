/*
Link - https://www.geeksforgeeks.org/problems/multiply-two-strings/1
Multiply two strings
Difficulty: MediumAccuracy: 20.06%Submissions: 240K+Points: 4Average Time: 20m
Given two numbers as strings s1 and s2. Calculate their Product.
Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers. There can be zeros in the begining of the numbers. You don't need to specify '+' sign in the begining of positive numbers.

Examples:

Input: s1 = "0033", s2 = "2"
Output: "66"
Explanation: 33 * 2 = 66
Input: s1 = "11", s2 = "23"
Output: "253"
Explanation: 11 * 23  = 253
Input: s1 = "123", s2 = "0"
Output: "0"
Explanation: Anything multiplied by 0 is equal to 0.
Constraints:
1 ≤ s1.size() ≤ 103
1 ≤ s2.size() ≤ 103

Expected Complexities
Time Complexity: O(n * m)
Auxiliary Space: O(n * m)
  */

class Solution {
    public String multiplyStrings(String s1, String s2) {
        // code here.
       
        
        boolean negative = false;
        if(s1.charAt(0) == '-')
        {
            negative = !negative;
            s1 = s1.substring(1);
        }
        if(s2.charAt(0) == '-')
        {
            negative = !negative;
            s2 = s2.substring(1);
        }
        
        s1 = s1.replaceFirst("^0+", "");
        s2 = s2.replaceFirst("^0+", "");
        
         if(s1.isEmpty() || s2.isEmpty()) return "0";
        
        int n = s1.length(), m = s2.length();
        int[] res = new int [n+m];
        for(int i = n-1; i>=0; i--)
        {
            int n1 = s1.charAt(i) - '0', m1 = 0;
            
            for(int j = m - 1; j >=0; j--)
            {
                m1 = s2.charAt(j) - '0';
                int product = n1 * m1;
            
            
            
            
            int pos1 = i + j;
            int pos2 = i + j + 1;
            
            int result = product + res[pos2];
            
            res[pos2] = result % 10;
            res[pos1] += result / 10;
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        
        for(int num: res)
        {
            if((num != 0 || sb.length() > 0))
            {
                sb.append(num);
            }
        }
        
        if(negative)
        {
            sb.insert(0, "-");
        }
        
        return sb.toString();
    }
}
