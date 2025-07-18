/*
https://leetcode.com/problems/search-a-2d-matrix-ii/description/
240. Search a 2D Matrix II
Solved
Medium
Topics
premium lock icon
Companies
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 

Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109
  */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowlength = matrix.length;
        int collength = matrix[0].length;
        int row = rowlength - 1;
        int col = 0;

        while(row >=0 && col < collength)
        {
            int value = matrix[row][col];
            if(value == target)
            return true;
            else if(value > target)
            row--;
            else
            col++;
        }

        return false;
    }
}
