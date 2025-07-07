/*
Link - https://www.geeksforgeeks.org/problems/sum-of-all-prime-numbers-between-1-and-n4404/1
Sum of all prime numbers between 1 and n
Difficulty: EasyAccuracy: 18.71%Submissions: 62K+Points: 2Average Time: 15m
Given a positive integer n, compute and return the sum of all prime numbers between 1 and n (inclusive).

A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.  

Examples:

Input: n = 5
Output: 10
Explanation: 2, 3 and 5 are prime numbers between 1 and 5(inclusive), and their sum is 2 + 3 + 5 = 10.
Input: n = 10
Output: 17
Explanation: 2, 3, 5 and 7 are prime numbers between 1 and 10(inclusive), and their sum is 2 + 3 + 5 + 7 = 17.
Constraints:
1 <= n <= 105

Expected Complexities
Time Complexity: O(nloglogn)
Auxiliary Space: O(n)
  */

class Solution {
    boolean[] sieve;
    public int prime_Sum(int n) {
         sieve = new boolean[n+1];
        // code here
        createSieve(n);
        int sum = 0; 
        for(int i = 2; i <=n; i++)
        {
            if(sieve[i])
            sum += i;
        }
        return sum;
    }
    
    private void createSieve(int n)
    {
        for(int i = 2; i <=n; i++)
        {
            sieve[i] = true;
        }
        
        for(int i = 2; i*i <=n; i++)
        {
            if(sieve[i] == true)
            {
                for(int j = i*i ; j <=n; j+=i)
                {
                    sieve[j] = false;
                }
            }
        }
    }
}
