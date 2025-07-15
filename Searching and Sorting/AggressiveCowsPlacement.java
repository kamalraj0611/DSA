/*
Lnk - https://www.geeksforgeeks.org/problems/aggressive-cows/0
Aggressive Cows
Difficulty: MediumAccuracy: 59.57%Submissions: 147K+Points: 4Average Time: 30m
You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Examples :

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.
Input: stalls[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows, in this case, is 4, which also is the largest among all possible ways.
Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
Output: 1
Explanation: Each cow can be placed in any of the stalls, as the no. of stalls are exactly equal to the number of cows.
The minimum distance between cows, in this case, is 1, which also is the largest among all possible ways.
Constraints:
2 <= stalls.size() <= 106
0 <= stalls[i] <= 108
2 <= k <= stalls.size()

Expected Complexities
Time Complexity: O(n log m)
Auxiliary Space: O(1)
  */

// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        
        Arrays.sort(stalls);
        int min = 1;
        int max = stalls[stalls.length - 1] - stalls[0];
        while (min <= max)
        {
            int mid = min + (max - min) / 2;
            
            if(canAssignStalls(stalls, mid, k))
            {
                min = mid + 1;
            }
            
            else
            {
                max = mid - 1;
            }
        }
        
        return max;
    }
    
    public static boolean canAssignStalls(int[] stalls, int size, int k) {
            int count = 1;
            int last = stalls[0];
            
            for (int i = 1; i < stalls.length; i++)
            {
                if(stalls[i] - last >= size)
                {
                    count++;
                    last = stalls[i];
                    
                    if(count == k) return true;
                }
            }
            
            return false;
        }
}
