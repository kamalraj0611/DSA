/*
Link - https://www.geeksforgeeks.org/problems/all-divisors-of-a-number/1
All divisors of a Number
Difficulty: EasyAccuracy: 46.73%Submissions: 59K+Points: 2Average Time: 10m
Given an integer n, print all the divisors of N in the ascending order.
 
Examples:

Input : n = 20
Output: 1 2 4 5 10 20
Explanation: 20 is completely divisible by 1, 2, 4, 5, 10 and 20.
Input: n = 21191
Output: 1 21191
Explanation: As 21191 is a prime number, it has only 2 factors(1 and the number itself).
Constraints:
1 ≤ n ≤ 109

Expected Complexities
Time Complexity: O(sqrt(n)
Auxiliary Space: O(sqrt(n))
*/

class Solution {
    public static void print_divisors(int n) {
        // code here
        
        List<Integer> small_divisors = new ArrayList<>();
        List<Integer> large_divisors = new ArrayList<>();
        for(int i = 1 ; i * i <=n; i++)
        {
            if(n % i == 0)
            {
                small_divisors.add(i);
                
                if(n/i != i)
                {
                    large_divisors.add(n/i);
                }
            }
        }
        
        for(int num: small_divisors)
        {
            System.out.print(num + " ");
        }
        
        for(int j = large_divisors.size()-1; j>=0;j--)
        {
            System.out.print(large_divisors.get(j) + " ");
        }
    }
}
