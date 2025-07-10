/*
Link - https://www.geeksforgeeks.org/problems/print-table0303/1
Multiplication Table
Difficulty: BasicAccuracy: 44.81%Submissions: 61K+Points: 1
Create the multiplication table from 1 to 10 for a given number n and return the table as an array.

Examples:

Input: n = 9
Output: 9 18 27 36 45 54 63 72 81 90
Input: n = 2
Output: 2 4 6 8 10 12 14 16 18 20
Constraints: 
1 <= N <= 106

Expected Complexities
Time Complexity: O(1)
Auxiliary Space: O(1)
*/

// User function Template for Java
class Solution {
    static ArrayList<Integer> getTable(int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i= 1 ; i<=10; i++)
        {
            result.add(i * n);
        }
        
        return result;
    }
}
