/*
https://www.geeksforgeeks.org/dsa/sum-manhattan-distances-pairs-points/
Sum of Manhattan distances between all pairs of points
Last Updated : 26 Mar, 2025
Given n integer coordinates. The task is to find the sum of the Manhattan distance between all pairs of coordinates. 
Manhattan Distance between (x1, y1) and (x2, y2) is: |x1 - x2| + |y1 - y2|

Examples : 

Input : n = 4, p1 = { -1, 5 }, p2 = { 1, 6 }, p3 = { 3, 5 }, p4 = { 2, 3 }
Output : 22
Explanation : 
Distance of { 1, 6 }, { 3, 5 }, { 2, 3 } from { -1, 5 } are 3, 4, 5 respectively. Therefore, sum = 3 + 4 + 5 = 12. 
Distance of { 3, 5 }, { 2, 3 } from { 1, 6 } are 3, 4 respectively. Therefore, sum = 12 + 3 + 4 = 19 
Distance of { 2, 3 } from { 3, 5 } is 3. Therefore, sum = 19 + 3 = 22.
  */

package com.kamal;

import java.util.Arrays;

public class Sum_of_Manhattan_distances_between_all_pairs_of_points {
    // Return the sum of distance between all
    // the pair of points.
    static int totaldistancesum(int x[], int y[], int n)
    {
       int distancex = distancesum(x, n);
       int distancey = distancesum(y, n);

       return distancex + distancey;
    }

    static int distancesum(int num[], int n)
    {
        Arrays.sort(num);
        int distance = 0; int presum = 0;
        for (int i = 0; i < n; i++)
        {
            distance += (num[i] * i - presum);
            presum += num[i];
        }
        return distance;
    }

    // Driven Program
        public static void main(String[] args)
        {

            int x[] = { -1, 1, 3, 2 };
            int y[] = { 5, 6, 5, 3 };
            int n = x.length;
            System.out.println(totaldistancesum(x,
                    y, n));
        }
}
