/*

1201. Ugly Number III
Solved
Medium
Topics
premium lock icon
Companies
Hint
An ugly number is a positive integer that is divisible by a, b, or c.

Given four integers n, a, b, and c, return the nth ugly number.

 

Example 1:

Input: n = 3, a = 2, b = 3, c = 5
Output: 4
Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
Example 2:

Input: n = 4, a = 2, b = 3, c = 4
Output: 6
Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
Example 3:

Input: n = 5, a = 2, b = 11, c = 13
Output: 10
Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
 

Constraints:

1 <= n, a, b, c <= 109
1 <= a * b * c <= 1018
It is guaranteed that the result will be in range [1, 2 * 109].
*/

class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
       long min = 1;
       long max = (long) n * Math.min(a, (Math.min(b, c))); 
        int result = 0;
       while (min <= max)
       {
        long mid = min + (max - min) / 2;
         
        long count = countNthUglyNumber(a, b, c,(int) mid);
        if(count < n)
        {
            min = mid + 1;
        }
        else
        {
            result = (int)mid;
            max = mid - 1;
        }
       }

       return result;
    }

    public static long countNthUglyNumber(long a, long b, long c, long mid) {
        long ab = lcm(a,b);
        long bc = lcm(b,c);
        long ca = lcm(c,a);
        long abc = lcm(a , bc); // equivalent to lcm(a,b,c)

        return (mid/a) + (mid/b) + (mid/c)
                    - (mid/ab) - (mid/bc) - (mid/ca)
                    + (mid/abc);
    }

    public static long gcd(long x, long y) {

       return (y==0) ? x :  gcd( y , (x % y));
    }

    public static long lcm(long x, long y) {

       return x / gcd(x , y) * y;// avoid overflow
    }
}
