/*
Link - https://leetcode.com/problems/count-primes/description/
204. Count Primes
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an integer n, return the number of prime numbers that are strictly less than n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106
  */

class Solution {
    boolean[] sieve;
    public int countPrimes(int n) {
        if(n == 0 || n ==1)
        return 0;
        int primeCount = 0;
        sieve = new boolean[n+1];
        createSieve(n);
        for(int i= 2; i <n; i++)
        {
            if (sieve[i])
            primeCount++;

        }
        return primeCount;
    }

    private void createSieve(int n)
    {
        for(int i = 2; i<n;i++)
        {
            sieve[i]=true;
        }

        for(int i = 2; i * i < n; i++)
        {
            if(sieve[i]==true)
            {
                for(int j = i * i; j < n; j+=i)
                {
                    sieve[j]=false;
                }
        
            }
        }
    }
}
