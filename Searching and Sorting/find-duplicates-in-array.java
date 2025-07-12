/*
Link - https://www.geeksforgeeks.org/problems/find-duplicates-in-an-array/1
Array Duplicates
Difficulty: EasyAccuracy: 18.95%Submissions: 837K+Points: 2Average Time: 20m
Given an array arr[] of integers, find all the elements that occur more than once in the array. If no element repeats, return an empty array.

Examples:

Input: arr[] = [2, 3, 1, 2, 3]
Output: [2, 3] 
Explanation: 2 and 3 occur more than once in the given array.
Input: arr[] = [0, 3, 1, 2] 
Output: []
Explanation: There is no repeating element in the array, so the output is empty.
Input: arr[] = [2]
Output: []
Explanation: There is single element in the array. Therefore output is empty.
Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 106

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)
  */

import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> duplicates= new ArrayList<Integer>();
        
        for(int element: arr)
        {
            map.put(element, map.getOrDefault(element,0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            if(entry.getValue() > 1)
            {
                duplicates.add(entry.getKey());
            }
        }
        
        return duplicates;
    }
}
