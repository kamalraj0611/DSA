/*
https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
Count Inversions
Difficulty: MediumAccuracy: 16.93%Submissions: 683K+Points: 4
Given an array of integers arr[]. You have to find the Inversion Count of the array. 
Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 104

Expected Complexities
Time Complexity: O(n log n)
Auxiliary Space: O(n)
  */

// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        int[] temp = new int[arr.length];
        return CountInversionsMergeSort(arr, temp, 0, arr.length - 1);
    }
    
    static int CountInversionsMergeSort(int arr[], int temp[], int left, int right) {
        // Your Code Here
        int count = 0; 
        int mid = left + (right - left) / 2;
        if (left < right)
        {
            count += CountInversionsMergeSort(arr, temp, left, mid);
            count += CountInversionsMergeSort(arr, temp, mid + 1, right);
            count += CountInversionsMerge(arr, temp, left, mid, right);
        }
        return count;
    }
    
    static int CountInversionsMerge(int arr[], int temp[], int left, int mid, int right) {
        // Your Code Here
        int i = left;
        int j = mid + 1;
        int k = left;
        int count = 0;
        
        while(i <= mid && j<=right)
        {
            if(arr[i] <= arr[j])
            {
                temp[k++] = arr[i++];
            }
            
            else
            {
            temp[k++] = arr[j++];
            count += mid - i + 1;
            }
        }
        
        while(i <= mid )
        {
            temp[k++] = arr[i++];
        }
        
         while(j<=right)
        {
           
            temp[k++] = arr[j++];
        }
        
        for(int idx = left; idx <= right; idx++)
        {
            arr[idx] = temp[idx];
        }
        return count;
    }
}
