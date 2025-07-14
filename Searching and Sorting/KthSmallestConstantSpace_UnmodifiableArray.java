/*
Link - https://www.geeksforgeeks.org/dsa/kth-smallest-element-in-the-array-using-constant-space-when-array-cant-be-modified/
Kth smallest element in the array using constant space when array can't be modified
Last Updated : 05 Dec, 2022
Given an array arr[] of size N having no duplicates and an integer K, the task is to find the Kth smallest element from the array in constant extra space and the array can't be modified.

Examples: 



Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 3 
Output: 7 
Given array in sorted is {3, 4, 7, 10, 15, 20} 
where 7 is the third smallest element.





Input: arr[] = {12, 3, 5, 7, 19}, K = 2 
Output: 5 
 



Approach: First we find the min and max elements from the array. Then we set low = min, high = max and mid = (low + high) / 2. 
Now, perform a modified binary search, and for each mid we count the number of elements less than mid and equal to mid. If countLess < k and countLess + countEqual ? k then mid is our answer, else we have to modify our low and high.
  */

public class Kth_smallest_element_in_the_array_using_constant_space_when_array_cannot_be_modified {
    public static int kthSmallest(int[] arr, int k) {
        int n = arr.length;

        // Find min and max elements
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int num : arr) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        // Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int countLess = 0;
            int countEqual = 0;

            // Count elements less than and equal to mid
            for (int num : arr) {
                if (num < mid) {
                    countLess++;
                } else if (num == mid) {
                    countEqual++;
                }
            }

            // Check if mid is the kth smallest
            if (countLess < k && countLess + countEqual >= k) {
                return mid;
            } else if (countLess >= k) {
                high = mid - 1; // go left
            } else {
                low = mid + 1;  // go right
            }
        }

        return -1; // should not reach here if input is valid
    }

    // ✅ Main method to test
    public static void main(String[] args) {
        int[] arr1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("Kth smallest: " + kthSmallest(arr1, k1)); // 7

        int[] arr2 = {12, 3, 5, 7, 19};
        int k2 = 2;
        System.out.println("Kth smallest: " + kthSmallest(arr2, k2)); // 5
    }
}
