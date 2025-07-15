/*
Link - https://www.geeksforgeeks.org/dsa/maximum-subarray-size-subarrays-size-sum-less-k/#expected-approach-using-sliding-window-on-time-and-o1-space
Maximum subarray size having all subarrays sums less than k
Last Updated : 07 Mar, 2025
Given an array of positive integers arr[] of size n, and an integer k. The task is to find the maximum subarray size such that all subarrays of that size have sum less than or equals to k.

Examples : 

Input :  arr[] = [1, 2, 3, 4], k = 8.
Output : 2
Explanation: Following are the sum of subarray of size 1 to 4.

Sum of subarrays of size 1: 1, 2, 3, 4. 
Sum of subarrays of size 2: 3, 5, 7. 
Sum of subarrays of size 3: 6, 9. 
Sum of subarrays of size 4: 10. 
So, maximum subarray size such that all subarrays of that size have the sum of elements less than 8 is 2.

Input:  arr[] = [1, 2, 10, 4], k = 8. 
Output : -1 
Explanation: There is an array element (10) with value greater than k, so subarray sum cannot be less than k. 

Input :  arr[] = [1, 2, 10, 4], k = 14 
Output : 2
  */
package com.kamal;

public class MaxSubarraySize {


    // Function to find the maximum subarray size
    public static int maxSubarraySize(int[] arr, int k) {
        int result = -1;
        int low = 1;
        int high = arr.length;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(isValid(arr, mid, k)) {
                result = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }

        return result;
    }

    public static boolean isValid(int[] arr, int size, int k) {
        int windowsum = 0;
        int n = arr.length;

        for(int i = 0; i < size; i++)
        {
            windowsum += arr[i];
        }

        if(windowsum > k)
            return false;

        for(int i = size; i < n; i++)
        {
            windowsum += arr[i] - arr[i - size];

            if(windowsum > k)
                return false;
        }




        return true;
    }

    // Main method to test the solution
    /*public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int k1 = 8;
        System.out.println("Maximum subarray size: " + maxSubarraySize(arr1, k1)); // Output: 2

        int[] arr2 = {1, 2, 10, 4};
        int k2 = 8;
        System.out.println("Maximum subarray size: " + maxSubarraySize(arr2, k2)); // Output: -1

        int[] arr3 = {1, 2, 10, 4};
        int k3 = 14;
        System.out.println("Maximum subarray size: " + maxSubarraySize(arr3, k3)); // Output: 2
    }*/
}
