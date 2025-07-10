/*
Link - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
34. Find First and Last Position of Element in Sorted Array
Solved
Medium
Topics
premium lock icon
Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
  */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int startingIndex= startingAndEnding(nums, target, true);
        int endingIndex= startingAndEnding(nums, target, false);
        return new int[]{startingIndex, endingIndex};
    }

    private int startingAndEnding(int[] nums, int target, boolean isStarting) {
        int start = 0;
        int end = nums.length - 1;
        int position = -1;
        while(start <= end)
        {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target)
            {
                position = mid;
                if(isStarting)
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }

            }
            else if(target > nums[mid])
            {
                start = mid + 1;
            }
            else
            {
                 end = mid - 1;
            }

        }

        return position;
    }

}
